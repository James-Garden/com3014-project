package uk.ac.surrey.com3014.jg01314.session;

import java.util.Random;

class SessionIdGenerator {

  private static final char[] SESSION_ID_CHARACTERS =
      "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private static final int SESSION_ID_CHARACTERS_LENGTH = SESSION_ID_CHARACTERS.length;
  private static final int SESSION_ID_LENGTH = 72;
  private static final Random RANDOM = new Random();

  private SessionIdGenerator() {
  }

  static String generateSessionId() {
    var sessionIdCharArray = new char[SESSION_ID_LENGTH];

    for (int i = 0; i < SESSION_ID_LENGTH; i++) {
      sessionIdCharArray[i] = SESSION_ID_CHARACTERS[RANDOM.nextInt(SESSION_ID_CHARACTERS_LENGTH)];
    }

    return new String(sessionIdCharArray);
  }
}
