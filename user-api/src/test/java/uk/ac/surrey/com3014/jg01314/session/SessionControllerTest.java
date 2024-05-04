package uk.ac.surrey.com3014.jg01314.session;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import uk.ac.surrey.com3014.jg01314.AbstractIntegrationTest;
import uk.ac.surrey.com3014.jg01314.user.User;
import uk.ac.surrey.com3014.jg01314.user.UserService;
import uk.ac.surrey.com3014.jg01314.user.UserTestUtil;
import uk.ac.surrey.com3014.jg01314.user.UserView;

@ExtendWith(MockitoExtension.class)
class SessionControllerTest extends AbstractIntegrationTest {

  @MockBean
  private UserService userService;

  @MockBean
  private SessionService sessionService;

  private final User user = UserTestUtil.userWithId();

  @Test
  void createSession_WhenNotFound_AssertUnauthorized() {
    when(userService.findByEmail(user.getEmail())).thenReturn(Optional.empty());

    var request = new CreateSessionRequest("nonexistantemail@test.com", "password");
    var response = testRestTemplate.postForEntity("/api/session", request, Void.class);

    verify(sessionService, never()).createSession(any());
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
  }

  @Test
  void createSession_WhenIncorrectPassword_AssertUnauthorized() {
    var incorrectPassword = "incorrectPassword";

    when(userService.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
    when(userService.verifyPassword(user, incorrectPassword)).thenReturn(false);

    var request = new CreateSessionRequest(user.getEmail(), incorrectPassword);
    var response = testRestTemplate.postForEntity("/api/session", request, Void.class);

    verify(sessionService, never()).createSession(any());
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
  }

  @Test
  void createSession_WhenCorrect_AssertOk() {
    var createdSession = new Session("some_session_id", user.getId());

    when(userService.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
    when(userService.verifyPassword(user, UserTestUtil.PASSWORD)).thenReturn(true);
    when(sessionService.createSession(user)).thenReturn(createdSession);

    var request = new CreateSessionRequest(user.getEmail(), UserTestUtil.PASSWORD);
    var response = testRestTemplate.postForEntity("/api/session", request, UserView.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getHeaders().get(HttpHeaders.SET_COOKIE))
        .contains("SessionID=" + createdSession.getId() + "; Secure; HttpOnly");
    assertThat(response.getBody()).isEqualTo(user.asView());
  }

  @Test
  void deleteSession_NonExistent_AssertNotFound() {
    var sessionId = SessionIdGenerator.generateSessionId();
    var entity = getHttpEntityWithSessionCookie(sessionId);

    when(sessionService.findSession(sessionId)).thenReturn(Optional.empty());

    var response = testRestTemplate.exchange("/api/session", HttpMethod.DELETE, entity, Void.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  @Test
  void deleteSession_WhenExists_AssertOk() {
    var session = new Session(SessionIdGenerator.generateSessionId(), 1);
    var entity = getHttpEntityWithSessionCookie(session.getId());

    when(sessionService.findSession(session.getId())).thenReturn(Optional.of(session));

    var response = testRestTemplate.exchange("/api/session", HttpMethod.DELETE, entity, Void.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  void verifySession_UserNotFound_AssertFalse() {
    var request = new VerifySessionRequest("some-session-id", user.getId());

    when(userService.findById(user.getId())).thenReturn(Optional.empty());

    var response = testRestTemplate.postForEntity("/api/session/verify", request, VerifySessionResponse.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody().isValidSession()).isFalse();
  }

  @Test
  void verifySession_SessionNotVerified_AssertFalse() {
    var sessionId = SessionIdGenerator.generateSessionId();
    var request = new VerifySessionRequest(sessionId, user.getId());

    when(userService.findById(user.getId())).thenReturn(Optional.of(user));
    when(sessionService.verifySession(user, sessionId)).thenReturn(false);

    var response = testRestTemplate.postForEntity("/api/session/verify", request, VerifySessionResponse.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody().isValidSession()).isFalse();
  }

  @Test
  void verifySession_SessionVerified_AssertTrue() {
    var sessionId = SessionIdGenerator.generateSessionId();
    var request = new VerifySessionRequest(sessionId, user.getId());

    when(userService.findById(user.getId())).thenReturn(Optional.of(user));
    when(sessionService.verifySession(user, sessionId)).thenReturn(true);

    var response = testRestTemplate.postForEntity("/api/session/verify", request, VerifySessionResponse.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody().isValidSession()).isTrue();
  }

  private HttpEntity<Void> getHttpEntityWithSessionCookie(String sessionId) {
    var headers = new HttpHeaders();
    headers.add("Cookie", "SessionID=" + sessionId);
    return new HttpEntity<>(null, headers);
  }
}
