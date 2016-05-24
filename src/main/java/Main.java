public class Main {

    public static void main (String[] args) {
        Game game = new Game();
        Console console = new MainConsole();
        RandomPlayer player2 = new RandomThrow();
        App app = new App(game, console, player2);
        app.start();
    }
}
