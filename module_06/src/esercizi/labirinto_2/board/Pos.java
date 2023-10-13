package esercizi.labirinto_2.board;

public class Pos {

    private int x;
    private int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Pos position = (Pos) obj;
        return position.x == this.x && position.y == this.y;
    }
}
