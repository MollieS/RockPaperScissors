import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementsTest {

    private Elements rock = new Rock();
    private Elements scissors = new Scissors();
    private Elements paper = new Paper();

    @Test
    public void rockHasName() {
        assertEquals("Rock", rock.name());
    }

    @Test
    public void scissorsHasName() {
        assertEquals("Scissors", scissors.name());
    }

    @Test
    public void paperHasName() {
        assertEquals("Paper", paper.name());
    }

    @Test
    public void rockBeatsScissors() {
        assertEquals("Rock", rock.winner(scissors));
    }

    @Test
    public void rockLosesToPaper() {
        assertEquals("Paper", rock.winner(paper));
    }

    @Test
    public void scissorsBeatPaper() {
        assertEquals("Scissors", scissors.winner(paper));
    }

    @Test
    public void scissorsLoseToRock() {
        assertEquals("Rock", scissors.winner(rock));
    }

    @Test
    public void paperBeatsRock() {
        assertEquals("Paper", paper.winner(rock));
    }

    @Test
    public void paperLosesToScissors() {
        assertEquals("Scissors", paper.winner(scissors));
    }
}
