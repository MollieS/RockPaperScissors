import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;

public class AppTest {

  private App app;
  private TestConsole testConsole;
  private MockedThrow player2;

  @Before
  public void setUp() {
    Game game = new Game();
    this.testConsole = new TestConsole();
    this.player2 = new MockedThrow();
    this.app = new App(game, testConsole, player2);
  }

  @Test
  public void greetsUser() {
    testConsole.giveInput("2");
    app.start();
    String output = testConsole.getOutput();
    assertThat(output, containsString("Welcome to RockPaperScissors!"));
  }

  @Test
  public void asksForInput() {
    testConsole.giveInput("2");
    app.start();
    String prompt = testConsole.getOutput();
    assertThat(prompt, containsString("Please choose:\n1: Rock\n2: Paper\n3: Scissors"));
  }

  @Test
  public void onlyTakesNumbersToThree() {
    testConsole.giveInput("4", "2");
    app.start();
    assertThat(testConsole.getOutput(), containsString("Please choose 1, 2 or 3"));
  }

  @Test
  public void promptsForValidInput() {
    testConsole.giveInput("Rock", "2");
    app.start();
    String error = testConsole.getOutput();
    assertThat(error, containsString("Please choose 1, 2 or 3"));
  }

  @Test
  public void loopsUntilValidInput() {
    testConsole.giveInput("Rock", "2");
    app.start();
    assertThat(testConsole.getOutput(), containsString("You chose Paper"));
  }

  @Test
  public void getsCorrectChoiceForOne() {
    testConsole.giveInput("1", "3");
    app.start();
    assertThat(testConsole.getOutput(), containsString("You chose Rock"));
  }

  @Test
  public void getsCorrectChoiceForTwo() {
    testConsole.giveInput("2");
    app.start();
    assertThat(testConsole.getOutput(), containsString("You chose Paper"));
  }

  @Test
  public void getsCorrectChoiceForThree() {
    testConsole.giveInput("3");
    app.start();
    assertThat(testConsole.getOutput(), containsString("You chose Scissor"));
  }

  @Test
  public void generatesOtherPlayerChoice() {
    assertEquals("Rock", app.generateChoice());
  }

  @Test
  public void returnsBothChoices() {
    app.turn("Rock", "Paper");
    assertThat(testConsole.getOutput(), containsString("Player Two chose Paper"));
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

  @Test
  public void playesAGame() {
    testConsole.giveInput("3", "quit");
    app.start();
    assertThat(testConsole.getOutput(), containsString("winner"));
  }

  @Test
  public void aDraw() {
    testConsole.giveInput("3", "3", "quit");
    app.turn("Rock", "Rock");
    assertThat(testConsole.getOutput(), containsString("It's a draw!"));
  }

  @Test
  public void loopsIfDraw() {
    testConsole.giveInput("3", "3", "quit");
    app.turn("Paper", "Paper");
    assertThat(testConsole.getOutput(), containsString("Play again"));
  }

}
