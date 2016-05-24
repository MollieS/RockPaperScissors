import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;

public class AppTest {

    private App app;
    private TestConsole testConsole;

    @Before
    public void setUp() {
        Game game = new Game();
        this.testConsole = new TestConsole();
        MockedThrow player2 = new MockedThrow();
        this.app = new App(game, testConsole, player2);
    }

    private void startGame(String... choices) {
        testConsole.giveInput(choices);
        app.start();
    }

    @Test
    public void greetsUser() {
        startGame("2");
        assertThat(testConsole.getOutput(), containsString("Welcome to RockPaperScissors!"));
    }

    @Test
    public void asksForInput() {
        startGame("2");
        assertThat(testConsole.getOutput(), containsString("Please choose:\n1: Rock\n2: Paper\n3: Scissors"));
    }

    @Test
    public void onlyTakesNumbersToThree() {
        startGame("4", "2");
        assertThat(testConsole.getOutput(), containsString("Please choose 1, 2 or 3"));
    }

    @Test
    public void promptsForValidInput() {
        startGame("Rock", "2");
        assertThat(testConsole.getOutput(), containsString("Please choose 1, 2 or 3"));
    }

    @Test
    public void loopsUntilValidInput() {
        startGame("Rock", "2");
        assertThat(testConsole.getOutput(), containsString("You chose Paper"));
    }

    @Test
    public void getsCorrectChoiceForOne() {
        startGame("1", "3");
        assertThat(testConsole.getOutput(), containsString("You chose Rock"));
    }

    @Test
    public void getsCorrectChoiceForTwo() {
        startGame("2");
        assertThat(testConsole.getOutput(), containsString("You chose Paper"));
    }

    @Test
    public void getsCorrectChoiceForThree() {
        startGame("3");
        assertThat(testConsole.getOutput(), containsString("You chose Scissor"));
    }

    @Test
    public void generatesOtherPlayerChoice() {
        assertEquals("Rock", app.generateChoice());
    }

    @Test
    public void returnsBothChoices() {
        startGame("3");
        assertThat(testConsole.getOutput(), containsString("Player Two chose Rock"));
    }

    @Test
    public void returnsWinningSymbol() {
        startGame("2");
        assertThat(testConsole.getOutput(), containsString("Paper wins!"));
    }

    @Test
    public void returnsWinningPlayer() {
        startGame("2");
        assertThat(testConsole.getOutput(), containsString("Player One is the winner!"));
    }

    @Test
    public void playsAGame() {
        startGame("3");
        assertThat(testConsole.getOutput(), containsString("winner"));
    }

    @Test
    public void aDraw() {
        startGame("1", "3");
        assertThat(testConsole.getOutput(), containsString("It's a draw!"));
    }

    @Test
    public void loopsIfDraw() {
        startGame("1", "3");
        assertThat(testConsole.getOutput(), containsString("Play again"));
    }
}
