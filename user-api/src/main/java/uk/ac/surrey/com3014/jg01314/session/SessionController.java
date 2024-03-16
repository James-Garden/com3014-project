package uk.ac.surrey.com3014.jg01314.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.surrey.com3014.jg01314.user.UserService;

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

  @PostMapping
  ResponseEntity<Void> createSession(@RequestBody CreateSessionRequest request,
                                                      HttpServletResponse response) {
    var user = userService.findByEmail(request.email())
        .filter(foundUser -> userService.verifyPassword(foundUser, request.password()))
        .orElseThrow(AuthenticationException::new);

    var session = sessionService.createSession(user);
    var sessionIdCookie = new Cookie("SessionID", session.getId());
    sessionIdCookie.setHttpOnly(true);
    sessionIdCookie.setSecure(true);
    response.addCookie(sessionIdCookie);

    return ResponseEntity.created(URI.create("/api/session")).build();
  }

}
