package esercizi.sequenza_iterabile;

import java.util.Arrays;

public class ListaDiInteri implements Iterabile, Sequenza {

    int[] array;
    int iterableIndex;

    ListaDiInteri() {
        clear();
        reset();
    }

    ListaDiInteri(int[] array) {
        this();
        this.array = array;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == (int)o)
                return i;
        }
        return -1;
    }

    public String toString() { return Arrays.toString(array); }

    @Override
    public Object get(int i) { return array[i]; }

    /**
     * @return lunghezza della lista di interi
     */
    @Override
    public int size() { return array.length; }

    /**
     * Aggiunge un valore nella lista di interi, estendendo la dimensione dell'array di 1
     *
     * @param o l'intero da aggiungere alla lista
     */
    @Override
    public void add(Object o) {
        // estendiamo la dimensione dell'array di 1
        // così da poter aggiungere un nuovo valore
        int[] tmp = new int[array.length+1];

        // copiamo ogni intero nel nuovo array esteso di lunghezza
        tmp = copy(array, tmp, array.length);
        // aggiungiamo il nuovo valore in ultima posizione
        tmp[tmp.length-1] = (int)o;

        // salviamo nel campo array il riferimento in memoria dell'array esteso
        array = tmp;
    }

    public int[] copy(int[] srcArray, int[] targetArray, int untilIndex) {
        // copiando la prima metà degli elementi nella stessa posizione in cui erano
        // fino all'indice a cui dobbiamo inserire
        for (int i = 0; i < untilIndex; i++) {
            targetArray[i] = srcArray[i];
        }
        return targetArray;
    }

    @Override
    public boolean remove(int index) {
        if (size() < index || index < 0) return false;

        // in caso contrario accorciamo l'array di 1
        int[] tmp = new int[array.length-1];

        tmp = copy(array, tmp, index);

        // copiamo la seconda metà degli elementi "shiftandoli di 1"
        for (int i = index; i < array.length-1; i++) {
            tmp[i] = array[i+1];
        }

        array = tmp;

        return true;
    }

    @Override
    public void clear() { array = new int[0]; }

    @Override
    public boolean hasNext() {
        return iterableIndex != size();
    }

    @Override
    public Object next() {
        return get(iterableIndex++);
    }

    @Override
    public void reset() { iterableIndex = 0; }
}
