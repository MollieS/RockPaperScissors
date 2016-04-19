import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;

public class GameTest {

  private Game game;

  @Before
  public void setUp() {
    game = new Game();
  }

  @Test
  public void greetsUser() {
    String greeting = game.greet();
    assertThat(greeting, containsString("Welcome to RockPaperScissors!"));
  }

  @Test
  public void asksForInput() {
    String prompt = game.promptForInput();
    assertThat(prompt, containsString("Please choose:\n1: Rock\n2: Paper\n3: Scissors"));
  }

  @Test
  public void onlyTakesNumbers() {
    assertFalse(game.validInput("Rock"));
    assertTrue(game.validInput("1"));
    assertTrue(game.validInput("2"));
    assertTrue(game.validInput("3"));
    assertFalse(game.validInput("4"));
  }

  @Test
  public void promptsForValidInput() {
    String error = game.input("Rock");
    assertThat(error, containsString("Please choose 1, 2 or 3"));
  }

  @Test
  public void getsCorrectChoice() {
    assertThat(game.input("1"), containsString("You chose Rock"));
    assertThat(game.input("2"), containsString("You chose Paper"));
    //    assertThat(game.input("3"), containsString("You chose Scissor"));
  }
}
