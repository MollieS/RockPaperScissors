import javax.lang.model.element.Element;

class Game {

    String winner;

    String play(String choice1, String choice2) {
        String winningElement = ElementFactory.create(choice1).winner(ElementFactory.create(choice2));
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
