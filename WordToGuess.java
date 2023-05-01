package spaceman.model;

import java.util.ArrayList;
import java.util.List;

// TODO: Add Javadoc
public class WordToGuess {

  private String completeWord;
  private List<GuessChar> revealedCharacters;

  WordToGuess(final String word) {
    completeWord = word;
    // TODO: initialize `revealedCharacters`.
    // All characters except for space (" ") should be initialized as hidden
    // GuessChar.
    // Spaces (" ") should be initialized as revealed GuessChar.

    revealedCharacters = new ArrayList<>();
    for (int i = 0; i < completeWord.length(); i++) {
      char c = completeWord.charAt(i);
      if (c == ' ') {
        revealedCharacters.add(new GuessChar(c, true));
      } else {
        revealedCharacters.add(new GuessChar(c, false));
      }
    }
    }


  /**
   * Return the complete word.
   */
  String getCompleteWord() {
    return completeWord;
  }

  /**
   * Return the length of the word.
   */
  public int getWordLength() {
    return completeWord.length();
  }

  /**
   * Get the list of characters in the word. Characters can be revealed or hidden. This information
   * is defined by the used {@link GuessChar}.
   *
   * @return the list of characters in the word (as <code>GuessChar</code>s).
   */
  public List<GuessChar> getCharacters() {
    return revealedCharacters;
  }

  /**
   * Guess the given character. If the character is in the word, all occurrences of the character
   * are revealed in the word.
   *
   * @param guessedCharacter character to guess.
   * @return <code>true</code>if the character is in the word. <code>false</code> otherwise.
   */
  boolean guess(final char guessedCharacter) {
    // TODO: implement. "revealing" a character means replacing the empty GuessChar
    // object at the corresponding
    // position in `revealedCharacters` with the correct character.

    boolean found = false;
    for (int i = 0; i < completeWord.length(); i++) {
      char c = completeWord.charAt(i);
      if (c == guessedCharacter) {
        revealedCharacters.set(i, new GuessChar(c, true));
        found = true;
      }
    }
    return found;
  }


    /** Reveal all characters. */
    void revealAll() {
      // TODO: implement.
      for (int i = 0; i < completeWord.length(); i++) {
        char c = completeWord.charAt(i);
        revealedCharacters.set(i, new GuessChar(c, true));
      }
    }
  }
