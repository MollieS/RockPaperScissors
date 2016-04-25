public class ComputerPlayer implements Player {

    private Randomizer randomizer;

    public ComputerPlayer(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    public String getChoice() {
        return randomizer.makeThrow();
    }
}
