import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;

public class AppTest {

  private App app;
  private Game game;
  private TestConsole testConsole;

  @Before
  public void setUp() {
    this.game = new Game();
    this.testConsole = new TestConsole();
    this.app = new App(game, testConsole);
  }

  @Test
  public void greetsUser() {
    app.greet();
    String output = testConsole.getOutput();
    assertThat(output, containsString("Welcome to RockPaperScissors!"));
  }

  @Test
  public void asksForInput() {
    app.promptForInput();
    String prompt = testConsole.getOutput();
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
    app.input("Rock");
    String error = testConsole.getOutput();
    assertThat(error, containsString("Please choose 1, 2 or 3"));
  }

  @Test
  public void getsCorrectChoiceForOne() {
    app.input("1");
    assertThat(testConsole.getOutput(), containsString("You chose Rock"));
  }

  @Test
  public void getsCorrectChoiceForTwo() {
    app.input("2");
    assertThat(testConsole.getOutput(), containsString("You chose Paper"));
  }

  @Test
  public void getsCorrectChoiceForThree() {
    app.input("3");
    assertThat(testConsole.getOutput(), containsString("You chose Scissor"));
  }

  @Test
  public void generatesOtherPlayerChoice() {
    assertNotEquals(null, app.generateChoice());
  }

  @Test
  public void returnsWinningSymbol() {
    app.turn("Rock", "Paper");
    assertThat(testConsole.getOutput(), containsString("Paper wins!"));
  }

  @Test
  public void returnsWinningPlayer() {
    app.turn("Rock", "Scissors");
    assertThat(testConsole.getOutput(), containsString("Player One is the winner!"));
  }
}
