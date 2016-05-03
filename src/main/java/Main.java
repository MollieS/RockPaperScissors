public class Main {

    public static void main (String[] args) {
        HumanPlayer player1 = new HumanPlayer();
        ComputerPlayer player2 = new ComputerPlayer(new RandomThrow());
        Game game = new Game();
        Console console = new MainConsole();
        App app = new App(game, console, player1, player2);
        app.start();
    }
}
