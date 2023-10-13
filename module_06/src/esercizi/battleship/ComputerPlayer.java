package esercizi.battleship;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String playerName) {
        super(playerName);
    }

    @Override
    public void takeShot(GameGrid opponentGrid) {
        Random random = new Random();
        int x, y;

        // Finchè non trovo una casella non ancora colpita
        do {
            x = random.nextInt(opponentGrid.gridSize);
            y = random.nextInt(opponentGrid.gridSize);
        } while (opponentGrid.grid[x][y].isHit);

        opponentGrid.grid[x][y].isHit = true;

        if (opponentGrid.grid[x][y].hasShip) {
            System.out.println(playerName + " hits at " + (char) ('A' + x) + (y + 1));
        } else {
            System.out.println(playerName + " misses at " + (char) ('A' + x) + (y + 1));
        }
    }

}
