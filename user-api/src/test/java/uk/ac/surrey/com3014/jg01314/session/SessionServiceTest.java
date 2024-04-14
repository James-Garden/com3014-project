package uk.ac.surrey.com3014.jg01314.session;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.ac.surrey.com3014.jg01314.user.User;
import uk.ac.surrey.com3014.jg01314.user.UserTestUtil;

@ExtendWith(MockitoExtension.class)
class SessionServiceTest {

  @Mock
  private SessionRepository sessionRepository;

  @InjectMocks
  private SessionService sessionService;

  @Captor
  private ArgumentCaptor<String> sessionIdCaptor;

  @Captor
  private ArgumentCaptor<Session> sessionCaptor;

  private final User user = UserTestUtil.userWithId();

  @Test
  void createSession() {
    sessionService.createSession(user);

    verify(sessionRepository).save(sessionCaptor.capture());

    var savedSession = sessionCaptor.getValue();

    assertThat(savedSession)
        .extracting(Session::getUserId)
        .isEqualTo(user.getId());
    assertThat(savedSession)
        .extracting(Session::getId)
        .isNotNull();
  }
}
