package esercizi.battleship;

public class BattleshipGame {
    public static void main(String[] args) throws Exception {
        GameGrid playerGrid = new GameGrid(5);
        GameGrid computerGrid = new GameGrid(5);

        HumanPlayer player = new HumanPlayer("Player 1");
        ComputerPlayer computer = new ComputerPlayer("Computer");

        player.placeShips(playerGrid);
        computer.placeShips(computerGrid);

        System.out.println("Player Grid:"); 
        playerGrid.printGrid();

        System.out.println("******************"); 

        System.out.println("Computer Grid:"); 
        computerGrid.printGrid();
        
        while (true) {
            player.takeShot(computerGrid);
            if (player.hasWon(computerGrid)) {
                System.out.println("Player 1 wins!");
                break;
            }

            computer.takeShot(playerGrid);
            if (computer.hasWon(playerGrid)) {
                System.out.println("Computer wins!");
                break;
            }
        }
    }
}