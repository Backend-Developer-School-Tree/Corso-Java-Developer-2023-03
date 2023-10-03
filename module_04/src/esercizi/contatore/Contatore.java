package esercizi.contatore;

public class Contatore {

    private int count;

    public Contatore(int count) {
        this.count = count;
    }

    /*
    Se ho definito un costruttore non vuoto, il costruttore di
    default non sarà presente.
     */
    public Contatore() {}

    /**
     * Questo metodo incrementa di uno il contatore
     */
    public void incrementa() {
        count++;
    }

    /**
     * Questo metodo ritorna il valore attuale del contatore
     * @return il contatore
     */
    public int getCount() {
        return count;
    }

    /**
     * Questo metodo setta il valore del contatore a 0
     */
    public void setZero() {
        count = 0;
    }

    /**
     * resetta il contatore con un nuovo valore in input
     * @param count il nuovo valore
     */
    public void setCount(int count) {
        this.count = count;
    }



}
