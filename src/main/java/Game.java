import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Game {

    private String playerOne;
    String winner;

    String play(String choice1, String choice2) {
        this.playerOne = choice1;
        List<String> choices = Arrays.asList(choice1, choice2);
        determineWinner(winningElement(choices));
        return winningElement(choices);
    }

    private String winningElement(List<String> choices) {
        if (choices.contains("Rock") && choices.contains("Paper")) return "Paper";
        if (choices.contains("Scissors") && choices.contains("Paper")) return "Scissors";
        if (choices.contains("Rock") && choices.contains("Scissors")) return "Rock";
        return null;
    }

    private void determineWinner(String winningElement) {
        if (winningElement == playerOne) {
            this.winner = "Player One";
        } else {
            this.winner = "Player Two";
        }
    }
}
