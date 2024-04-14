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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import uk.ac.surrey.com3014.jg01314.AbstractIntegrationTest;
import uk.ac.surrey.com3014.jg01314.user.User;
import uk.ac.surrey.com3014.jg01314.user.UserService;
import uk.ac.surrey.com3014.jg01314.user.UserTestUtil;

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
    var response = testRestTemplate.postForEntity("/api/session", request, Void.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getHeaders().get(HttpHeaders.SET_COOKIE))
        .contains("SessionID=" + createdSession.getId() + "; Secure; HttpOnly");
  }
}
