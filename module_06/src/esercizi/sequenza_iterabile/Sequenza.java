package esercizi.sequenza_iterabile;

public interface Sequenza {
    /**
     * Verifica se un elemento è presente all'interno della sequenza
     *
     * @param o elemento da trovare nella sequenza
     * @return `true` se l'elemento è presente nella sequenza, `false` altrimenti
     */
    default boolean contains(Object o) { return indexOf(o) != -1; }

    /**
     * Restituisce l'elemento alla posizione i della sequenza
     *
     * @param i indice dell'elemento da restituire
     * @return l'elemento alla posizione i della sequenza
     */
    Object get(int i);

    /**
     * Restituisce l’indice della posizione dell’elemento fornito in input
     *
     * @param o elemento di cui cercare la posizione all'interno della sequenza
     * @return l'indice dell'elemento cercato se presente, -1 altrimenti
     */
    public int indexOf(Object o);

    /**
     * Ritorna il numero di elementi presenti all'interno della sequenza
     *
     * @return il numero di elementi presenti all'interno della sequenza
     */
    int size();

    /**
     * Aggiunge un elemento alla sequenza
     *
     * @param o elemento da aggiungere alla sequenza
     */
    void add(Object o);

    /**
     * Rimuove l'elemento alla posizione i della sequenza,
     * torna `true` se l'elemento è stato rimosso, `false` altrimenti
     *
     * @param i indice dell'elemento da rimuovere
     * @return `true` se l'elemento è stato rimosso, `false` altrimenti
     */
    boolean remove(int i);

    /**
     * Rimuove tutti gli elementi dalla sequenza
     */
    void clear();
}
