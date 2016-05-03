import java.util.HashMap;

class App {
    private HashMap<String, String> options = new HashMap();
    private Game game;
    private HumanPlayer player1;
    private Console console;
    private Player player2;

    App(Game game, Console console, HumanPlayer player1, Player player2) {
        this.game = game;
        this.console = console;
        this.player1 = player1;
        this.player2 = player2;
        setOptions();
    }

    void start() {
        greet();
        promptForInput();
        loopForInput();
        turn(player1.getChoice(), player2.getChoice());
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
            player1.setChoice(options.get(word));
            console.print("You chose " + player1.getChoice());
        } else {
            console.print("Please choose 1, 2 or 3");
        }
    }

    void turn(String choice1, String choice2) {
        console.print("Player Two chose " + choice2);
        if (choice1 == choice2) {
            console.print("It's a draw!");
            player1.setChoice(null);
            loopForDraw();
        } else {
            console.print(game.play(choice1, choice2) + " wins!");
            console.print(game.winner + " is the winner!");
        }
    }

    private void loopForInput() {
        while (player1.getChoice() == null) {
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
