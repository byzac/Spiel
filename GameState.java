package spaceman.model;

//  TODO: add javadoc
/** This class represents the current state of the Spaceman game. */
public class GameState {

  private Phase currentPhase;
  private WordToGuess wordToGuess;
  private Countdown countdown;
  private int initialCountdownValue;

  /**
   * Create a new game state with a word to guess yb the player and a countdown value.
   *
   * @param word the word to guess.
   * @param countdownValue the countdown value.
   */
  GameState(final String word, final int countdownValue) {
    wordToGuess = new WordToGuess(word);
    countdown = new Countdown(countdownValue);
    initialCountdownValue = countdownValue;
    currentPhase = Phase.RUNNING;
  }

  // TODO: add methods to set state values
  /**
   * Set the current phase of the game.
   *
   * @param phase the game phase.
   */
  public void setCurrentPhase(Phase phase) {
    this.currentPhase = phase;
  }

  /**
   * Set the word to guess.
   *
   * @param wordToGuess the word to guess.
   */
  public void setWordToGuess(WordToGuess wordToGuess) {
    this.wordToGuess = wordToGuess;
  }

  /**
   * Set the countdown.
   *
   * @param countdown the new countdown
   */
  public void setCountdown(Countdown countdown){
    this.countdown = countdown;
  }

  /**
   * Set the current countdown value.
   *
   * @param countdownValue the new countdown value.
   */
  public void setInitialCountdownValue(int countdownValue) {
    this.initialCountdownValue = countdownValue;
  }

  /**
   * Return the current phase of the game.
   *
   * @return the current phase.
   */
  public Phase getCurrentPhase() {
    return currentPhase;
  }

  /**
   * Get the word to guess.
   *
   * @return the word to guess.
   */
  public WordToGuess getWord() {
    return wordToGuess;
  }

  /**
   * Get the countdown value.
   *
   * @return the current countdown value.
   */
  public int getCountdownValue() {
    return countdown.getCurrentValue();
  }

  /**
   * Get the initial countdown value.
   *
   * @return the initial countdown value.
   */
  public int getMaximumCountdownValue() {
    return initialCountdownValue;
  }
}
