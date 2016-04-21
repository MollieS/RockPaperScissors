public class Main {

    public static void main (String[] args) {
        Game game = new Game();
        Console console = new MainConsole();
        App app = new App(game, console);
        app.start();
    }
}
