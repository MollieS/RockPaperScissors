import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class RandomThrowTest {

    @Test
    public void returnsAnInteger() {
        RandomThrow player2 = new RandomThrow();
        assertNotEquals(null, player2.makeThrow());
    }
}
