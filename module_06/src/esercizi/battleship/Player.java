package esercizi.battleship;

import java.util.Random;
import java.util.Scanner;

public class Player {
    String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void takeShot(GameGrid opponentGrid) {
        Scanner scanner = new Scanner(System.in);
        String shotInput;
        int x, y;
    
        while (true) {
            System.out.println(playerName + ", take a shot (e.g., A2): ");
            shotInput = scanner.nextLine().trim().toUpperCase();

            if (shotInput.matches("[A-E][1-5]")) {
                char column = shotInput.charAt(0);
                x = Integer.parseInt(shotInput.substring(1)) - 1;
                y = column - 'A';
    
                if (!opponentGrid.grid[x][y].isHit) {
                    opponentGrid.grid[x][y].isHit = true;
    
                    if (opponentGrid.grid[x][y].hasShip) {
                        System.out.println("Hit!");
                    } else {
                        System.out.println("Miss!");
                    }
    
                    break;
                } else {
                    System.out.println("You already shot there. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please use the format (e.g., A2).");
            }
        }
    }


    public boolean hasWon(GameGrid opponentGrid) {
        for (int i = 0; i < opponentGrid.gridSize; i++) {
            for (int j = 0; j < opponentGrid.gridSize; j++) {
                if (opponentGrid.grid[i][j].hasShip && !opponentGrid.grid[i][j].isHit) {
                    return false; 
                }
            }
        }
        return true;
    }


    public void placeShips(GameGrid grid) {
        Random random = new Random();

        for (int shipSize = 1; shipSize > 0; shipSize--) {
            boolean shipPlaced = false;

            while (!shipPlaced) {
                int x = random.nextInt(grid.gridSize);
                int y = random.nextInt(grid.gridSize);
                boolean isVertical = random.nextBoolean();

                if (canPlaceShip(grid, x, y, shipSize, isVertical)) {
                    placeShip(grid, x, y, shipSize, isVertical);
                    shipPlaced = true;
                }
            }
        }
    }


    private boolean canPlaceShip(GameGrid grid, int x, int y, int size, boolean isVertical) {
        if (isVertical) {
            if (x + size > grid.gridSize) {
                return false;
            }

            for (int i = x; i < x + size; i++) {
                if (grid.grid[i][y].hasShip) {
                    return false;
                }
            }

        } else {
            if (y + size > grid.gridSize) {
                return false;
            }

            for (int j = y; j < y + size; j++) {
                if (grid.grid[x][j].hasShip) {
                    return false;
                }
            }
        }

        return true;
    }


    private void placeShip(GameGrid grid, int x, int y, int size, boolean isVertical) {
        if (isVertical) {
            for (int i = x; i < x + size; i++) {
                grid.grid[i][y].hasShip = true;
            }
        } else {
            for (int j = y; j < y + size; j++) {
                grid.grid[x][j].hasShip = true;
            }
        }
    }
}