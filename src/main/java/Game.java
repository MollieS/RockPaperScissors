public class Game {

  public String play(String choice1, String choice2) {
    String winningChoice =  winner(choice1, choice2);
    return winningChoice + " wins!";
  }

  private String winner(String choice1, String choice2) {
    if (choice1 == "Rock" && choice2 == "Paper") return "Paper";
    if (choice1 == "Scissors" && choice2 == "Paper") return "Scissors";
    if (choice1 == "Scissors" && choice2 == "Rock") return "Rock";
    return null;
  }
}
