public interface Elements {

    String name();
    String weakness();

    default String winner(Elements element) {
        if (element.name() == this.weakness()) {
            return element.name();
        } else {
            return name();
        }
    }
}
