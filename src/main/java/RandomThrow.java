import java.util.Random;

public class RandomThrow implements Randomizer{

    public String makeThrow() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }
}
