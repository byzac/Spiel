
package spaceman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import spaceman.model.Spaceman;
// TODO: add javadoc
public class Shell {

  // TODO: Add array constant that holds the 7 steps of the flying saucer
  // 1.:
  //        _.---._
  //      .'       '.
  // 2.:
  //  _.-~===========~-._
  // 3.:
  // (___________________)
  // 4.:
  //       \_______/
  // 5.:
  //        |     |
  // 6.:
  //        |_0/  |
  // 7.:
  //        |  \  |
  //        |  /\ |


  private static final String[] FLYING_SAUCER_STEPS = {
          "        _.---._\n      .'       '.",
          "  _.-~===========~-._",
          " (___________________)",
          "       \\_______/",
          "        |     |",
          "        |_0/  |",
          "        |  \\  |\n        |  /\\ |"
  };

  // TODO: add String constants for 'SP> ' prompt and others, if necessary
  private static final String PROMPT = "SP> ";
  private static final String COMMAND_NEWGAME = "NEWGAME";
  private static final String COMMAND_NEWGAME_GIVEN_WORD = "NEWGAME %s";
  private static final String COMMAND_GUESS_CHAR = "GUESS $CHAR";
  private static final String COMMAND_DISPLAY = "DISPLAY";
  private static final String COMMAND_FORFEIT = "FORFEIT";
  private static final String QUIT = "QUIT";

  /**
   * Read and process input until the quit command has been entered.
   *
   * @param args Command line arguments.
   * @throws IOException Error reading from stdin.
   */
  public static void main(String[] args) throws IOException {
    final Shell shell = new Shell();
    shell.run();
  }

  /**
   * Run the spaceman shell. Shows prompt 'SP> ', takes commands from the user and executes them.
   */
  public void run() throws IOException {
    BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    boolean quit = false;
    Spaceman game = null;

    while (!quit) {
      // TODO: add prompt, read user input and handle the commands by parsing and calling the
      // corresponding method
      // (if a separate method makes sense - see below)
      System.out.print(PROMPT);
      String input = in.readLine();
      String[] commands = input.split(" ");

      switch (commands[0]) {
        case COMMAND_NEWGAME:
          game = Spaceman.create();
          System.out.println("New game created.");
          break;

        case COMMAND_NEWGAME_GIVEN_WORD:
          if (commands.length > 1) {
            String word = commands[1];
            game = Spaceman.create(word);
            System.out.println("New game created with word to guess: " + word);
          } else {
            System.out.println("Please provide a word to guess.");
          }
          break;

        case COMMAND_GUESS_CHAR:
          if (game == null || commands.length != 2 || commands[1].length() != 1) {
            System.out.println("Error! Invalid input.");
            break;
          }
          boolean guessed = game.guess(commands[1].charAt(0));
          if (guessed) {
            System.out.println("Correct guess! Current word: " + game.getState().getWord());
          } else {
            System.out.println("Wrong guess. Current UFO state:\n" + FLYING_SAUCER_STEPS[game.getState().getCountdownValue()]);
          }
          break;

        case COMMAND_DISPLAY:
          if (game == null) {
            System.out.println("Error! Invalid input.");
            break;
          }
          System.out.println("Current UFO state:\n" + FLYING_SAUCER_STEPS[game.getState().getCountdownValue()]);
          System.out.println("Current word: " + game.getState().getWord());
          break;

        case COMMAND_FORFEIT:
          if (game == null) {
            System.out.println("Error! Invalid input.");
            break;
          }
          game.forfeit();
          System.out.println("Game forfeited. The word was: " + game.getState().getWord());
          game = null;
          break;

        case QUIT:
          System.out.println("Quitting game. Goodbye!");
          quit = true;
          break;

        default:
          System.out.println("Error! Invalid input.");
          break;
      }
    }
  }

}

// TIP: Add one method for each of the following actions, to structure your code well:
// * NEWGAME
// * NEWGAME $GIVEN_WORD
// * GUESS $CHAR
// * DISPLAY
// * FORFEIT
