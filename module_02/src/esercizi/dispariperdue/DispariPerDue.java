package esercizi.dispariperdue;

public class DispariPerDue {

    /*
    Scrivete una funzione che dato un
    array di valori ne restituisce una copia dove i numeri dispari
    sono stati moltiplicati per 2.
     */
    public static int[] dispariPerDue(int[] array) {
        int[] array_copia = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) array_copia[i] = array[i];
            else array_copia[i] = 2*array[i];
        }
        return array_copia;
    }

}
