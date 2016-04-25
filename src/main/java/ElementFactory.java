public class ElementFactory {
    public static Elements create(String element) {
        if (element == "Rock") {
            return new Rock();
        } else if (element == "Paper"){
            return new Paper();
        } else if (element == "Scissors") {
            return new Scissors();
        } else {
            return null;
        }
    }
}
