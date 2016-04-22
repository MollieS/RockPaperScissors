import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Game {

    private String playerOne;

    String winner;

    String play(Elements choice1, Elements choice2) {
        return choice1.winner(choice2);
    }

    private void determineWinner(String winningElement) {
        if (winningElement == playerOne) {
            this.winner = "Player One";
        } else {
            this.winner = "Player Two";
        }
    }
}
