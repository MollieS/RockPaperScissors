import java.util.Scanner;

public class MainConsole implements Console {

  private App app;
  
  public MainConsole(App app) {
    this.app = app;
  }

  public void start() {
    System.out.println(app.greet());
    System.out.println(app.promptForInput());
    getValidInput();
    play();
  }

  public void getValidInput() {
    while (app.choice == null) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(app.input(scanner.next()));
    }
  }

  public void play() {
    System.out.println(app.turn(app.hand, app.generateChoice()));
  }

}
