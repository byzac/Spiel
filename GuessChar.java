package spaceman.model;

import java.util.Optional;

/** This class contains a single character guess. This can be either an unrevealed character or a revealed character. */
public class GuessChar {

  // Optional.empty() if the character was not guessed yet.
  // Optional.of(char), otherwise.
  private final Optional<Character> character;

  /** Creates an empty GuessChar. */
  GuessChar() {
    character = Optional.empty();
  }

  /**
   * Creates a GuessChar with the corresponding revealed character.
   *
   * @param revealedChar a character that has been revealed by guess
   * @param b
   */
  GuessChar(char revealedChar, boolean b) {
    character = Optional.of(revealedChar);
  }

  // TODO: Add Javadoc
  /**
   * Returns an Optional that contains the guessed character
   * or returns an empty Optional if the character is not revealed yet.
   *
   * @return an Optional object with the guessed character
   * or an empty Optional if the character is not revealed
   */
  public Optional<Character> maybeGetCharacter() {
    return character;
  }
}
