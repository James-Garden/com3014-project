package uk.ac.surrey.com3014.jg01314.session;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SessionIdGeneratorTest {

  @Test
  void generateSessionId() {
    var sessionId = SessionIdGenerator.generateSessionId();

    assertThat(sessionId).hasSize(72);
  }

  @Test
  void generateSessionId_AssertUnique() {
    var keySet = new HashSet<String>();

    for (int i = 0; i < 10000; i++) {
      var key = SessionIdGenerator.generateSessionId();
      if (!keySet.add(key)) {
        fail("Found duplicate key: " + key);
      }
    }
  }
}
