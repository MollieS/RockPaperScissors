public class HumanPlayer implements Player {

    private String hand;

    public void setChoice(String choice) {
        hand = choice;
    }

    public String getChoice() {
        return hand;
    }
}
