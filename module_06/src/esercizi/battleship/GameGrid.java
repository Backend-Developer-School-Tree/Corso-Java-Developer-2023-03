package esercizi.battleship;

public class GameGrid {
    int gridSize;
    Cell[][] grid;

    public GameGrid(int gridSize) {
        this.gridSize = gridSize;
        grid = new Cell[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void printGrid() {
        System.out.println("  A B C D E"); 
        for (int i = 0; i < gridSize; i++) {
            System.out.print((i + 1) + " "); 
            
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j].isHit) {
                    if (grid[i][j].hasShip) {
                        System.out.print("X "); 
                    } else {
                        System.out.print("O "); 
                    }
                } else {
                    if (grid[i][j].hasShip) {
                        System.out.print("S "); 
                    } else {
                        System.out.print("~ ");
                    }
                }
            }
            System.out.println();
        }
    }
}