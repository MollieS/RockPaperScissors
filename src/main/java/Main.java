public class Main {

  public static void main(String[] args) {
    Game game = new Game();
    App app = new App(game);
    Console console = new MainConsole(app);
    console.start();
  }
}
