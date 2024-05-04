package uk.ac.surrey.com3014.jg01314.session;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.surrey.com3014.jg01314.user.User;

@Service
class SessionService {

  private final SessionRepository sessionRepository;

  @Autowired
  SessionService(SessionRepository sessionRepository) {
    this.sessionRepository = sessionRepository;
  }

  Session createSession(User user) {
    var session = new Session(SessionIdGenerator.generateSessionId(), user.getId());
    return sessionRepository.save(session);
  }

  Optional<Session> findSession(String sessionId) {
    return sessionRepository.findById(sessionId);
  }

  void deleteSession(Session session) {
    sessionRepository.delete(session);
  }

  public boolean verifySession(User user, String sessionId) {
    return findSession(sessionId)
        .map(session -> session.getUserId().equals(user.getId()))
        .orElse(false);

  }
}
