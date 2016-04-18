import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class GameTest {

  @Test
  public void greetsUser() {
    Game game = new Game();
    String greeting = game.greet();
    assertThat(greeting, containsString("Welcome to RockPaperScissors!"));
  }

  @Test
  public void asksForInput() {
    Game game = new Game();
    String prompt = game.promptForInput();
    assertThat(prompt, containsString("Please choose:\n1: Rock\n2: Paper\n3: Scissors"));
  }
}
