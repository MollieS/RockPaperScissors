import java.util.HashMap;
import java.util.Random;

class App {
    private HashMap<String, String> options = new HashMap();
    private Game game;
    private String hand;
    private Console console;

    App(Game game, Console console) {
        this.game = game;
        this.console = console;
        setOptions();
    }

    void start() {
        greet();
        promptForInput();
        loopForInput();
        turn(hand, generateChoice());
    }

    private void setOptions() {
        options.put("1", "Rock");
        options.put("2", "Paper");
        options.put("3", "Scissors");
    }

    private void greet() {
        console.print("Welcome to RockPaperScissors!");
    }

    private void promptForInput() {
        console.print("Please choose:\n1: Rock\n2: Paper\n3: Scissors");
    }

    private boolean validInput(String input) {
        return options.containsKey(input);
    }

    private void input(String word) {
        if (validInput(word)) {
            hand = options.get(word);
            console.print("You chose " + hand);
        } else {
            console.print("Please choose 1, 2 or 3");
        }
    }

    String generateChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    void turn(String choice1, String choice2) {
        console.print("Player Two chose " + choice2);
        if (choice1 == choice2) {
            console.print("It's a draw!");
            hand = null;
            loopForDraw();
        } else {
            console.print(game.play(choice1, choice2) + " wins!");
            console.print(game.winner + " is the winner!");
        }
    }

    private void loopForInput() {
        while (hand == null) {
            input(console.read());
        }
    }

    private void loopForDraw() {
        while (game.winner == null) {
            console.print("Play again");
            start();
        }
    }
}
