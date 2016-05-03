import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void determinesWinningElement() {
        assertThat(game.play("Rock", "Paper"), containsString("Paper"));
        assertThat(game.play("Scissors", "Paper"), containsString("Scissors"));
        assertThat(game.play("Scissors", "Rock"), containsString("Rock"));
        assertThat(game.play("Rock", "Scissors"), containsString("Rock"));
        assertThat(game.play("Paper", "Scissors"), containsString("Scissors"));
        assertThat(game.play("Paper", "Rock"), containsString("Paper"));
    }

    @Test
    public void determinesWinner() {
        game.play("Rock", "Paper");
        assertThat(game.winner, containsString("Player Two"));
    }
}
