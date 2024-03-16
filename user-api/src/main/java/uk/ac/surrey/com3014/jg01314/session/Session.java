package uk.ac.surrey.com3014.jg01314.session;

import jakarta.persistence.Id;
import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "Session", timeToLive = 86_400L)
class Session implements Serializable {

  @Id
  @Indexed
  private final String id;

  @Indexed
  private final Integer userId;

  Session(String id, Integer userId) {
    this.id = id;
    this.userId = userId;
  }

  String getId() {
    return id;
  }

  Integer getUserId() {
    return userId;
  }
}
