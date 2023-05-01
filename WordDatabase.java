package spaceman.model;

import java.util.Random;

/** Class that contains all possible words for guessing. */
class WordDatabase {

  private static final String[] WORDS = {
    "Spaceman", "Alien", "Earthling", "Homo Sapiens",
  };

  /**
   * Return a randomly chosen word from the word database. Words are chosen randomly according to a
   * uniform distribution.
   */
  static String getWord() {
    Random random = new Random();
    int index = random.nextInt(WORDS.length);
    return WORDS[index];
  }
}
