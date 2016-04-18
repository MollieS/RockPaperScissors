public class Game {

  public String greet() {
    return "Welcome to RockPaperScissors!";
  }

  public String promptForInput() {
    return "Please choose:\n1: Rock\n2: Paper\n3: Scissors";
  }

  public boolean validInput(String input) {
    if (input != "1" && input != "2" && input != "3") return false;
    return true;
  }

  public String input(String word) {
    if (validInput(word)) {
      return null;
    } else {
      return "Please choose 1, 2 or 3";
    }
  }
}
