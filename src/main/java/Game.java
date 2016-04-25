class Game {

    String winner;

    String play(String choice1, String choice2) {
        Elements element1 = ElementFactory.create(choice1);
        Elements element2 = ElementFactory.create(choice2);
        String winningElement = element1.winner(element2);
        determineWinner(winningElement, choice1);
        return winningElement;
    }

    private void determineWinner(String winningElement, String choice) {
        if (winningElement == choice) {
            this.winner = "Player One";
        } else {
            this.winner = "Player Two";
        }
    }
}
