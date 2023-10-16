package esercizi.labirinto_2.enums;

public enum Direction {

    UP("w"), DOWN("s"), RIGHT("d"), LEFT("a");

    private String button;

    Direction(String button) {
        this.button = button;
    }

    public String getButton() {
        return button;
    }
}
