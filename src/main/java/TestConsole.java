public class TestConsole implements Console {

  private String output = "";
  private String input = "";

  public void print(String word) {
    output += word;
  }

  public String read() {
    return input;
  }

  public String getOutput() {
    return output;
  }

  public void giveInput(String word) {
    input += word;
  }
}
