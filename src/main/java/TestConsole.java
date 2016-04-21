import java.util.ArrayList;
import java.util.Arrays;

public class TestConsole implements Console {

    private String output = "";
    private ArrayList<String> input = new ArrayList();

    public void print(String word) {
        output += word;
    }

    public String read() {
        return input.remove(0);
    }

    public String getOutput() {
        return output;
    }

    public void giveInput(String... words) {
        input.addAll(Arrays.asList(words));
    }
}
