import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

public class ConsoleTest {

  private Game game;
  private App app;
  private Console testConsole;

  @Before
  public void setUp() {
    Game game = new Game();
    App app = new App(game);
    Console testConsole = new TestConsole(app);
  }

  @Test
  public void greetsUser() {
    testConsole.start();
    assertTrue(testConsole.output.contains("Welcome"));
  }
}
