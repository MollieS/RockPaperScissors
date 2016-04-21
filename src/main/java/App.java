import java.util.HashMap;
import java.util.Random;

public class App {
  private HashMap<String, String> options = new HashMap();
  private Game game;
  public String choice;
  public String hand;
  private Console console;

  public App(Game game, Console console) {
    this.game = game;
    this.console = console;
    setOptions();
  }

  private void setOptions() {
    options.put("1", "Rock");
    options.put("2", "Paper");
    options.put("3", "Scissors");
  }

  public void greet() {
    console.print("Welcome to RockPaperScissors!");
  }

  public void promptForInput() {
    console.print("Please choose:\n1: Rock\n2: Paper\n3: Scissors");
  }

  public boolean validInput(String input) {
    return options.containsKey(input);
  }

  public void input(String word) {
    if (validInput(word)) {
      this.choice = word;
      hand = options.get(word);
      console.print("You chose " + hand);
    } else {
      console.print("Please choose 1, 2 or 3");
    }
  }

  public String generateChoice() {
    String[] choices = {"Rock", "Paper", "Scissors"};
    Random random = new Random();
    int index = random.nextInt(choices.length);
    return choices[index];
  }

  public void turn (String choice1, String choice2) {
    String winningHand = game.play(choice1, choice2);
    console.print(winningHand + " wins!\n" + game.winner + " is the winner!");
  }
}
