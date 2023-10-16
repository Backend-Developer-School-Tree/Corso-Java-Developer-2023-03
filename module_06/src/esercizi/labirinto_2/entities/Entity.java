package esercizi.labirinto_2.entities;

public abstract class Entity {

    protected static int idTot = 0;
    protected int id;
    protected String symbol;

    public Entity() {
        this.id = idTot;
        idTot++;
    }

    /**
     * getter per l'id dell'entità
     * @return l'id
     */
    public int getId() {
        return id;
    }

    /**
     * getter per il simbolo identificativo dell'entità
     * @return il simbolo
     */
    public String getSymbol() {
        return symbol;
    }
}
