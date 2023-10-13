package esercizi.labirinto_2;

import esercizi.labirinto_2.board.Labyrinth;
import esercizi.labirinto_2.factories.LabyrinthFactory;

public class Main {

    public static void main(String[] args) {
        LabyrinthFactory labyrinthFactory = new LabyrinthFactory();
        Labyrinth labyrinth = labyrinthFactory.randomLabyrinth(8,8);
        System.out.println(labyrinth);
    }

}
