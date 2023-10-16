package esercizi.labirinto_2.board;

import esercizi.labirinto_2.entities.EmptySpace;
import esercizi.labirinto_2.entities.Entity;
import esercizi.labirinto_2.entities.Exit;
import esercizi.labirinto_2.entities.Player;
import esercizi.labirinto_2.enums.Direction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Labyrinth {

    private int width; // numero di colonne
    private int height; // numero di righe
    private Map<Pos, Entity> map;

    public Labyrinth() {
        map = new HashMap<>();
    }

    public Labyrinth(int width, int height, Map<Pos, Entity> map) {
        this.width = width;
        this.height = height;
        this.map = map;
    }

    /**
     * getter per l'altezza della mappa (coordinata y)
     * @return l'altezza della mappa
     */
    public int getHeight() {
        return height;
    }

    /**
     * getter per la larghezza della mappa (coordinata x)
     * @return la larghezza della mappa
     */
    public int getWidth() {
        return width;
    }

    /**
     * Questo metodo restituisce il labirinto
     * @return il labirinto
     */
    public Map<Pos, Entity> getMap() {
        return map;
    }

    /**
     * Questo metodo ritorna l'entità contenuta nella posizione p,
     * se p è valida
     * @param p una posizione della mappa
     * @return l'entità in quella posizione
     */
    public Entity getEntity(Pos p) {
        if (isPos(p)) return map.get(p);
        else {
            System.out.println("ERRORE! Posizione non valida");
            return null;
        }
    }

    /**
     * Questo metodo prende in input una posizione e una direzione e ritorna
     * la posizione (se valida) adiacente in quella direzione.
     * @param p una posizione di partenza
     * @param dir una direzione
     * @return la posizione adiacente a p in direzione dir
     */
    public Pos getAdjacent(Pos p, Direction dir) {
        if (!isPos(p)) {
            System.out.println("ERRORE! Posizione di partenza non valida");
            return null;
        }
        switch (dir) {
            case UP -> {
                Pos pos_up = new Pos(p.getX(), p.getY()-1);
                if (isPos(pos_up)) return pos_up;
            }
            case DOWN -> {
                Pos pos_down = new Pos(p.getX(), p.getY()+1);
                if (isPos(pos_down)) return pos_down;
            }
            case LEFT -> {
                Pos pos_left = new Pos(p.getX()-1, p.getY());
                if (isPos(pos_left)) return pos_left;
            }
            case RIGHT -> {
                Pos pos_right = new Pos(p.getX()+1, p.getY());
                if (isPos(pos_right)) return pos_right;
            }
            default -> System.out.println("Direzione non valida");
        }
        System.out.println("Posizione adiacente non valida!");
        return null;
    }

    /**
     * Questo metodo ritorna true se p è una posizione valida
     * @param p una posizione
     * @return true se p è una posizione valida della mappa
     */
    public boolean isPos(Pos p) {
        if ((p.getX() < 0 || p.getX() >= width) ||
                p.getY() < 0 || p.getY() >= height) {
            return false;
        }
        return true;
    }

    /**
     * Questo metodo inserisce una entità e nella posizione p
     * @param p la posizione della mappa
     * @param e l'entità da mettere nella posizione p
     */
    public void putEntity(Pos p, Entity e) {
        if (isPos(p)) {
            map.put(p,e);
        }
        else System.out.println("ERRORE! Posizione non valida.");
    }

    /**
     * questo metodo ritorna l'insieme delle direzioni nelle quali posso muovermi
     * a partire da una casella.
     * @param p la posizione di partenza
     * @return l'insieme delle direzioni nelle quali il giocatore può muoversi
     */
    public Set<Direction> validMoves(Pos p) {
        if (!isPos(p)) {
            System.out.println("ERRORE! Posizione non valida");
            return null;
        }
        if (!(getEntity(p) instanceof Player)) {
            System.out.println("ERRORE! Giocatore o mostro non presente");
            return null;
        }
        Set<Direction> directions = new HashSet<>();
        // controllo la casella a sinistra
        Pos pos_sinistra = new Pos(p.getX() - 1, p.getY());
        if (isPos(pos_sinistra)) { // se la posizione a sinistra è valida
            Entity e = getEntity(pos_sinistra);
            if (e instanceof EmptySpace || e instanceof Exit) {
                directions.add(Direction.LEFT);
            }
        }
        // controllo la casella a destra
        Pos pos_destra = new Pos(p.getX() + 1, p.getY());
        if (isPos(pos_destra)) { // se la posizione a destra è valida
            Entity e = getEntity(pos_destra);
            if (e instanceof EmptySpace || e instanceof Exit) {
                directions.add(Direction.RIGHT);
            }
        }
        // controllo la casella in alto
        Pos pos_alto = new Pos(p.getX(), p.getY()-1);
        if (isPos(pos_alto)) { // se la posizione a sinistra è valida
            Entity e = getEntity(pos_alto);
            if (e instanceof EmptySpace || e instanceof Exit) {
                directions.add(Direction.UP);
            }
        }
        // controllo la casella in basso
        Pos pos_basso = new Pos(p.getX(), p.getY()+1);
        if (isPos(pos_basso)) { // se la posizione a sinistra è valida
            Entity e = getEntity(pos_basso);
            if (e instanceof EmptySpace || e instanceof Exit) {
                directions.add(Direction.DOWN);
            }
        }
        return directions;
    }

    /**
     * Muove un Player dalla posizione p in una certa direzione dir
     * @param p la posizione dove si trova il player
     * @param dir la direzione in cui si deve muovere (se valida)
     */
    public void movePlayer(Pos p, Direction dir) {
        if (!isPos(p)) {
            System.out.println("ERRORE! Posizione non valida");
            return;
        }
        if (!(getEntity(p) instanceof Player)) {
            System.out.println("ERRORE! Giocatore o mostro non presente");
            return;
        }
        if (!validMoves(p).contains(dir)) { // se dir non è una direzione valida
            System.out.println("ERRORE! Direzione non valida");
            return;
        }
        Player player = (Player) getEntity(p);
        switch (dir) {
            case UP -> {
                putEntity(new Pos(p.getX(), p.getY()-1), player);
                putEntity(p, new EmptySpace());
            }
            case DOWN -> {
                putEntity(new Pos(p.getX(), p.getY()+1), player);
                putEntity(p, new EmptySpace());
            }
            case LEFT -> {
                putEntity(new Pos(p.getX()-1, p.getY()), player);
                putEntity(p, new EmptySpace());
            }
            case RIGHT -> {
                putEntity(new Pos(p.getX()+1, p.getY()), player);
                putEntity(p, new EmptySpace());
            }
            default -> System.out.println("Direzione non valida");
        }
    }

    @Override
    public String toString() {
        String s = "";
        int counter = 0;
        for (Pos p: map.keySet()) {
            s += getEntity(p).getSymbol() + " ";
            if (counter == 8) {
                s += "\n";
                counter = 0;
            }
            counter++;
        }
        return s;
    }
}
