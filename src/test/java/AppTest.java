import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;

public class AppTest {

  private App app;

  @Before
  public void setUp() {
    Game game = new Game();
    Console testConsole = new TestConsole();
    app = new App(game, testConsole);
  }

  @Test
  public void greetsUser() {
    String greeting = app.greet();
    assertThat(greeting, containsString("Welcome to RockPaperScissors!"));
  }

  @Test
  public void asksForInput() {
    String prompt = app.promptForInput();
    assertThat(prompt, containsString("Please choose:\n1: Rock\n2: Paper\n3: Scissors"));
  }

  @Test
  public void onlyTakesNumbers() {
    assertFalse(app.validInput("Rock"));
    assertTrue(app.validInput("1"));
    assertTrue(app.validInput("2"));
    assertTrue(app.validInput("3"));
    assertFalse(app.validInput("4"));
  }

  @Test
  public void promptsForValidInput() {
    String error = app.input("Rock");
    assertThat(error, containsString("Please choose 1, 2 or 3"));
  }

  @Test
  public void getsCorrectChoice() {
    assertThat(app.input("1"), containsString("You chose Rock"));
    assertThat(app.input("2"), containsString("You chose Paper"));
    assertThat(app.input("3"), containsString("You chose Scissor"));
  }

  @Test
  public void generatesOtherPlayerChoice() {
    assertNotEquals(null, app.generateChoice());
  }

  @Test
  public void returnsWinningSymbol() {
    assertThat(app.turn("Rock", "Paper"), containsString("Paper wins!"));
  }

  @Test
  public void returnsWinningPlayer() {
    assertThat(app.turn("Rock", "Scissors"), containsString("Player One is the winner!"));
  }
}
