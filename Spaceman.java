package spaceman.model;

// TODO: add javadoc

import java.util.Objects;

/** This class represents the Spaceman game itself. */
public class Spaceman {

  /** Value the game countdown is started with. */
  private static final int COUNTDOWN_START = 7;

  private GameState state;


  /**
   * Constructor to create new Spaceman game with word to guess.
   *
   * @param wordToGuess the word to guess in the Spaceman game
   */
  private Spaceman(final String wordToGuess) {
    // TODO: set game state with word to guess
    Objects.requireNonNull(wordToGuess, "Error! Word to guess must not be null");
    this.state = new GameState(wordToGuess, COUNTDOWN_START);
  }

  /**
   * Create a new Spaceman game with a word chosen randomly from the {@link WordDatabase}.
   *
   * @return Spaceman instance with the random word
   */
  public static Spaceman create() {
    // TODO: Ask word database for a word, return new Spaceman object with that word
    String randomWord = WordDatabase.getWord();
    return new Spaceman(randomWord);
  }

  /**
   * Create a Spaceman object with the given word.
   *
   * @param wordToGuess word to use for the game
   * @return Spaceman instance for the given word
   */
  public static Spaceman create(String wordToGuess) {
    // TODO: Create a Spaceman object with the given word
    return new Spaceman(wordToGuess);
  }

  /**
   * Get the current game state.
   *
   * @return the current game state.
   */
  public GameState getState() {
    return state;
  }

  /**
   * Guess the given character. If the character is in the current word to guess, all occurrences of
   * the character are revealed in the word. If the character is not in the current word to guess,
   * the countdown decreases by one.
   *
   * <p>This method can only be called on an active game. Otherwise, an <code>IllegalStateException
   * </code> is thrown.
   *
   * <p>If the guess is correct and the whole word is revealed as a consequence, the game is
   * stopped.
   *
   * @param guessedCharacter character to guess
   * @return <code>true</code>if the guess was successful. <code>false</code> otherwise
   * @throws IllegalStateException if the current Spaceman game is not running
   */
  public boolean guess(char guessedCharacter) {
    // TODO: Check whether game is still running and throw an IllegalStateException
    // otherwise
    // TODO: Check whether the guessed character is in the current word to guess and
    // reveal it/decrease the countdown.
    // TODO: If the countdown reached 0 or the full word is revealed, change the game state
    // accordingly.
    if (state.getCurrentPhase() != Phase.RUNNING) {
      throw new IllegalStateException("Error! No Game running.");
    }

    /**
     * Check if the guessed Character is correct
     */
     boolean isCorrectGuess = state.getWord().guess(guessedCharacter);
      if (!isCorrectGuess) {
        decrease(state.getCountdownValue());
      }

      if (state.getCountdownValue() == 0 || state.getWord().getCompleteWord().equals(state.getWord())){
        state.setCurrentPhase(Phase.FINISHED);
      } else if (state.getWord().guess(guessedCharacter)) {
        state.setCurrentPhase(Phase.RUNNING);
      }

      return isCorrectGuess;
      }

  /**
   * Forfeit the current game. Fully reveal the word-to-guess and end the current game.
   *
   * <p>This method can only be called on an active game. Otherwise, an <code>IllegalStateException
   * </code> is thrown.
   *
   * @throws IllegalStateException if the current Spaceman game is not running
   */
  public void forfeit() {
    // TODO: Implement the game end (tip: this can probably be the same logic as the
    // end-case in `#guess`.)

    if (state.getCurrentPhase() != Phase.RUNNING){
      throw new IllegalStateException("Error! No game running.");
    }

    state.getWord().revealAll();
    state.setCurrentPhase(Phase.FINISHED);

  }

  private void decrease(int countdownValue){
    state.setInitialCountdownValue(countdownValue-1);
  }


}

