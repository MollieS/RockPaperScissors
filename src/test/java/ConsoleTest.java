import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ConsoleTest {

  private Game game;
  private App app;
  private TestConsole testConsole;

  @Before
  public void setUp() {
    this.testConsole = new TestConsole();
  }

  @Test
  public void outputs() {
    testConsole.print("Hello");
    assertEquals("Hello", testConsole.getOutput());
  }

  @Test
  public void readsInput() {
    testConsole.giveInput("Goodbye");
    assertEquals("Goodbye", testConsole.read());
  }
}
