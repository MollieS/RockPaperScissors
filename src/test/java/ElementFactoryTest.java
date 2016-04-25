import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementFactoryTest {

    @Test
    public void createsRock() {
        Elements rock = ElementFactory.create("Rock");
        assertEquals("Rock", rock.name());
    }

    @Test
    public void createsPaper() {
        Elements paper = ElementFactory.create("Paper");
        assertEquals("Paper", paper.name());
    }

    @Test
    public void createsScissors() {
        Elements scissors = ElementFactory.create("Scissors");
        assertEquals("Scissors", scissors.name());
    }

    @Test
    public void invalidOption() {
        Elements error = ElementFactory.create("Water");
        assertEquals(null, error);
    }
}
