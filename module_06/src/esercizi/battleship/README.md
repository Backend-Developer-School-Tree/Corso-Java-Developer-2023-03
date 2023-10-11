Purpose of the exercise: Implement a simplified version of the "Battleship" board game using Java in the terminal. The game will consist of a player against the computer.

Game rules:

- The playing field will be a square grid of predefined dimensions (e.g., 5x5).
- The player and the computer will each have a single ship of predefined size (e.g., 3 cells) to place on the grid.
- The ships can be placed horizontally or vertically, but not diagonally.
- Players will take turns attempting to hit the opponent's ship by firing at a cell on the grid.
- If a shot hits an opponent's ship, it will be marked as "hit" (e.g., with the symbol 'X'), otherwise, it will be marked as "miss" (e.g., with the symbol 'O').
- The game ends when one of the ships is completely hit.
- A final message will be displayed indicating the winner of the game.

Implementation tips:

- Use a matrix to represent the game grid.
- In the first version, use predetermined positions when creating the matrix.
- Implement the logic for the player's and computer's turns.
- Display the game grid after each shot taken.
- Determine the winner based on the opponent's ship being completely hit.