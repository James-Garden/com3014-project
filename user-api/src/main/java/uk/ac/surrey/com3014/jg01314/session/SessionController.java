package uk.ac.surrey.com3014.jg01314.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.surrey.com3014.jg01314.exception.EntityNotFoundException;
import uk.ac.surrey.com3014.jg01314.exception.UnauthorisedException;
import uk.ac.surrey.com3014.jg01314.user.UserService;
import uk.ac.surrey.com3014.jg01314.user.UserView;

@RestController
@RequestMapping("/api/session")
class SessionController {

  private final UserService userService;
  private final SessionService sessionService;

  @Autowired
  SessionController(UserService userService, SessionService sessionService) {
    this.userService = userService;
    this.sessionService = sessionService;
  }

  @PostMapping("/verify")
  ResponseEntity<VerifySessionResponse> verifySession(@RequestBody VerifySessionRequest request) {
    var isSessionValid = userService.findById(request.userId())
        .map(user -> sessionService.verifySession(user, request.sessionId()))
        .orElse(false);

    return ResponseEntity.ok(new VerifySessionResponse(isSessionValid));
  }

  @PostMapping
  ResponseEntity<UserView> createSession(@RequestBody CreateSessionRequest request,
                                         HttpServletResponse response) {
    var user = userService.findByEmail(request.email())
        .filter(foundUser -> userService.verifyPassword(foundUser, request.password()))
        .orElseThrow(UnauthorisedException::new);

    var session = sessionService.createSession(user);
    var sessionIdCookie = new Cookie("SessionID", session.getId());
    sessionIdCookie.setHttpOnly(true);
    sessionIdCookie.setSecure(true);
    response.addCookie(sessionIdCookie);

    return ResponseEntity.ok(user.asView());
  }

  @DeleteMapping
  ResponseEntity<Void> deleteSession(@CookieValue("SessionID") String sessionId,
                                     HttpServletResponse response) {
    var sessionIdCookie = new Cookie("SessionID", sessionId);
    sessionIdCookie.setMaxAge(0); // Cause the cookie to expire immediately, this is the only way to delete a HttpOnly cookie
    sessionIdCookie.setHttpOnly(true);
    sessionIdCookie.setSecure(true);
    response.addCookie(sessionIdCookie);

    var session = sessionService.findSession(sessionId)
        .orElseThrow(EntityNotFoundException::new);

    sessionService.deleteSession(session);

    return ResponseEntity.ok().build();
  }

}
