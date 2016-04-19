import java.util.HashMap;

public class App {
  private HashMap<String, String> options = new HashMap();

  public App() {
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
}
