package module_07.src.esempi.collections.hash_map_test;

import java.util.*;

public class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    public static void main(String[] args) {
        HashMap<Position, Integer> map = new HashMap<>();
        map.put(new Position(0, 1), 10);
        map.put(new Position(1, 1), 0);

        System.out.println(map);

        System.out.println(map.get(new Position(0,1)));
    }
}
