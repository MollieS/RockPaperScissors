import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void canSetChoiceforHuman() {
        HumanPlayer humanPlayer = new HumanPlayer();
        humanPlayer.setChoice("Rock");
        assertEquals("Rock", humanPlayer.getChoice());
    }

    @Test
    public void canGetComputerChoice() {
        Randomizer testRandomizer = new TestRandomizer();
        ComputerPlayer cpuPlayer = new ComputerPlayer(testRandomizer);
        assertEquals("Rock", cpuPlayer.getChoice());
    }
}
