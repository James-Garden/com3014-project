package uk.ac.surrey.com3014.jg01314.user;

import java.util.Random;
import org.testcontainers.shaded.org.apache.commons.lang3.reflect.FieldUtils;

public class UserTestUtil {

  public static final String USERNAME = "John";
  public static final String EMAIL = "jsmith123@example.com";
  public static final String PASSWORD = "Password123";
  private static final Random RANDOM = new Random();

  private UserTestUtil() {
  }

  public static User userWithId() {
    var user = new User(USERNAME, EMAIL, PASSWORD);
    try {
      FieldUtils.writeField(user, "id", RANDOM.nextInt(), true);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return user;
  }

}
