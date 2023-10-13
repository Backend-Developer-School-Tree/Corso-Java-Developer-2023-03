package esercizi.labirinto_2.factories;

import esercizi.labirinto_2.board.Labyrinth;
import esercizi.labirinto_2.board.Pos;
import esercizi.labirinto_2.entities.*;
import esercizi.labirinto_2.enums.Direction;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LabyrinthFactory {

    /**
     * Questo metodo ritorna un labirinto vuoto, cioè senza entità
     * sopra, ma solo le posizioni.
     * @param width la larghezza (coordinata x) della mappa.
     * @param height la lunghezza (coordinata y) della mappa.
     * @return un labirinto vuoto.
     */
    public Labyrinth voidLabyrinth(int width, int height) {
        Map<Pos, Entity> new_map = new HashMap<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pos pos = new Pos(j, i);
                new_map.put(pos, new Wall());
            }
        }
        System.out.println(new_map);
        return new Labyrinth(width, height, new_map);
    }

    public Labyrinth randomLabyrinth(int width, int height) {
        Labyrinth myLabyrinth = voidLabyrinth(width, height);
        System.out.println(myLabyrinth);
        Random random = new Random();
        // setto l'uscita randomicamente sull'ultima colonna
        int exit_number = random.nextInt(0,height);
        Exit exit = new Exit();
        Pos myPosition = new Pos(width-1, exit_number);
        myLabyrinth.putEntity(myPosition, exit);
        // calcolo randomicamente il numero di caselle che compongono il percorso
        int meta_caselle = (width*height) / 2;
        int num_caselle_percorso = random.nextInt(
                meta_caselle - meta_caselle / 2, meta_caselle + meta_caselle / 2);
        int attuale_percorso = 0;

        while (attuale_percorso < num_caselle_percorso) {
            int next_number = random.nextInt(1,5);
            switch (next_number) {
                case 1 -> {
                    Pos adjacent = myLabyrinth.getAdjacent(myPosition, Direction.UP);
                    if (adjacent == null || myLabyrinth.getEntity(adjacent) instanceof Exit) {
                        continue;
                    }
                    myLabyrinth.putEntity(adjacent, new EmptySpace());
                    myPosition = adjacent;
                    attuale_percorso++;
                }
                case 2 -> {
                    Pos adjacent = myLabyrinth.getAdjacent(myPosition, Direction.RIGHT);
                    if (adjacent == null || myLabyrinth.getEntity(adjacent) instanceof Exit) {
                        continue;
                    }
                    myLabyrinth.putEntity(adjacent, new EmptySpace());
                    myPosition = adjacent;
                    attuale_percorso++;
                }
                case 3 -> {
                    Pos adjacent = myLabyrinth.getAdjacent(myPosition, Direction.DOWN);
                    if (adjacent == null || myLabyrinth.getEntity(adjacent) instanceof Exit) {
                        continue;
                    }
                    myLabyrinth.putEntity(adjacent, new EmptySpace());
                    myPosition = adjacent;
                    attuale_percorso++;
                }
                case 4 -> {
                    Pos adjacent = myLabyrinth.getAdjacent(myPosition, Direction.LEFT);
                    if (adjacent == null || myLabyrinth.getEntity(adjacent) instanceof Exit) {
                        continue;
                    }
                    myLabyrinth.putEntity(adjacent, new EmptySpace());
                    myPosition = adjacent;
                    attuale_percorso++;
                }
            }
        }
        myLabyrinth.putEntity(myPosition, new Player());
        return myLabyrinth;
    }

}
