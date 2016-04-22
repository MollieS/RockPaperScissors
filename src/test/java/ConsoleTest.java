import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ConsoleTest {

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

  @Test
  public void readsTwoInputs() {
    testConsole.giveInput("Hello", "Goodbye");
    testConsole.read();
    assertEquals("Goodbye", testConsole.read());
  }
}
