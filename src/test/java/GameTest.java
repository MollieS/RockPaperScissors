import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import org.junit.Before;

public class GameTest {

  private Game game;

  @Before
  public void setUp() {
    game = new Game();
  }

  @Test
  public void determinesWinner() {
    assertThat(game.play("Rock", "Paper"), containsString("Paper wins!"));
    assertThat(game.play("Scissors", "Paper"), containsString("Scissors wins!"));
    assertThat(game.play("Scissors", "Rock"), containsString("Rock wins!"));
  }
}
