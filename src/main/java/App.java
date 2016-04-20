import java.util.HashMap;
import java.util.Random;

public class App {
  private HashMap<String, String> options = new HashMap();
  private Game game;

  public App(Game game) {
    this.game = game;
    options.put("1", "Rock");
    options.put("2", "Paper");
    options.put("3", "Scissors");
  }

  public String greet() {
    return "Welcome to RockPaperScissors!";
  }

  public String promptForInput() {
    return "Please choose:\n1: Rock\n2: Paper\n3: Scissors";
  }

  public boolean validInput(String input) {
    return options.containsKey(input);
  }

  public String input(String word) {
    if (validInput(word)) {
      return "You chose " + options.get(word);
    } else {
      return "Please choose 1, 2 or 3";
    }
  }

  public String generateChoice() {
    String[] choices = {"Rock", "Paper", "Scissors"};
    Random random = new Random();
    int index = random.nextInt(choices.length);
    return choices[index];
  }

  public String turn (String choice1, String choice2) {
    String winningHand = game.play(choice1, choice2);
    return winningHand + " wins!\n" + game.winner + " is the winner!";
  }
}
