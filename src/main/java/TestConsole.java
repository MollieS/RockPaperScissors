
public class TestConsole implements Console {

  private App app;
  public String output;

  public TestConsole(App app) {
    this.app = app;
    this.output = "";
  }

  public void start() {
     output.concat(app.greet());
  }
  
}
