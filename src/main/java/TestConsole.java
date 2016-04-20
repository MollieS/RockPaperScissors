public class TestConsole implements Console {

  private App app;
  private String output;
  private String[] input;

  public TestConsole(App app) {
    this.app = app;
  }

  public void start() {
    output += app.greet();
    output += app.promptForInput();
  }

  public String output() {
    return output;
  }

  public void input(String... words) {
    input = words;
    getValidInput();
  }

  public void getValidInput() {
    int i = 0;
    while (app.choice == null ) {
      output += app.input(input[i]);
      i++;
    }
    play();
  }

  public String getInput() {
    return input[0];
  }

  private void play() {
    output += app.turn(app.hand, app.generateChoice());
  }
}
