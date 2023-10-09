package esercizi.sequenza_iterabile;

public interface Iterabile {
    /**
     * Scorre la sequenza al prossimo elemento e lo ritorna
     *
     * @return il successivo elemento della sequenza
     */
    Object next();

    /**
     * Verifica se è presente un prossimo elemento nella sequenza
     *
     * @return `true` se è presente un successivo elemento, `false` altrimenti
     */
    boolean hasNext();

    /**
     * Resetta l'indice di iterazione (torna all'inizio)
     */
    void reset();
}
