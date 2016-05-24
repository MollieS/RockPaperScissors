class Game {

    private String playerOne;

    String winner;

    String play(String choice1, String choice2) {
        if (choice1 == choice2) {
            return null;
        } else {
            playerOne = choice1;
            Elements element1 = findElement(choice1);
            Elements element2 = findElement(choice2);
            String winningElement = element1.winner(element2);
            determineWinner(winningElement);
            return winningElement;
        }
    }

    private void determineWinner(String winningElement) {
        if (winningElement == playerOne) {
            this.winner = "Player One";
        } else {
            this.winner = "Player Two";
        }
    }

    private Elements findElement(String name) {
        if (name == "Rock") {
            return new Rock();
        } else if (name == "Paper") {
            return new Paper();
        } else {
            return new Scissors();
        }
    }
}
