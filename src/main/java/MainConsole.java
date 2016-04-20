import java.util.Scanner;

public class MainConsole implements Console{

  public void print(String word) {
    System.out.println(word);
  }

  public String read() {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    return input;
  }
}
