import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ConsoleTest {

  private Game game;
  private App app;
  private TestConsole testConsole;

  @Before
  public void setUp() {
    this.game = new Game();
    this.app = new App(game);
    this.testConsole = new TestConsole(app);
  }

  @Test
  public void greetsUser() {
    testConsole.start();
    assertTrue((testConsole.output()).contains("Welcome"));
  }

  @Test
  public void getsInput() {
    testConsole.start();
    testConsole.input("1");
    assertTrue((testConsole.getInput()).contains("1"));
  }

  @Test
  public void loopsUntilValidInput() {
    testConsole.start();
    testConsole.input("Blah", "7", "1");
    assertTrue(testConsole.output().contains("You chose Rock"));
  }

  @Test
  public void returnsWinner() {
    testConsole.input("1");
    assertTrue(testConsole.output().contains("Player"));
  }
}
