package esempi;

import java.util.Arrays;

public class Ricorsione {

    public static void main(String[] args) {
        // System.out.println(fibonacci(5));
        // System.out.println(fattoriale(5));
        int[] array = new int[]{1,2,3,4};
        System.out.println(sommaIterativa(array));
        System.out.println(sommaRicorsiva(array));
        System.out.println(sommaRicorsiva2(array));
    }

    public static int fibonacci(int n) {
        // casi base
        if (n == 0) return 0;
        if (n == 1) return 1;

        // chiamate ricorsive
        return fibonacci(n-1) + fibonacci(n-2);
        // fibonacci(5) = fibonacci(4) + fibonacci(3)
        // fibonacci(4) = fibonacci(3) + fibonacci(2)
        // fibonacci(3) = fibonacci(2) + fibonacci(1)
        // fibonacci(2) = fibonacci(1) + fibonacci(0)
    }

    public static int fattoriale(int n) {
        // caso base
        if (n == 0) return 1;

        // chiamata ricorsiva
        return n * fattoriale(n-1);
    }

    public static int sommaIterativa(int[] array) {
        int cnt = 0;
        for (int i = 0; i < array.length; i++) cnt += array[i];
        return cnt;
    }

    // l'Overloading ci permette di definire più volte un metodo con lo stesso nome ma con numero di parametri o tipo diversi,
    // utile per prevedere la stessa funzionalità su tipi di input diversi (es. int, long, ecc) o per creare funzioni di appoggio

    // public static int sommaRicorsiva(long[] array) { }

    // public static String sommaRicorsiva(int[] array) { }

    public static int sommaRicorsiva(int[] array) {
        // caso base
        // se l'array è lungo uno la somma degli elementi è l'unico elemento presente
        if (array.length == 1) return array[0];

        // caso ricorsivo
        // sommiamo l'ultimo elemento dell'array alla somma ricorsiva dell'array senza l'ultimo elemento
        return array[array.length-1] + sommaRicorsiva(Arrays.copyOf(array, array.length-1));
    }

    public static int sommaRicorsiva2(int[] array, int i) {
        // caso base
        if (i == 0) return 0;

        // caso ricorsivo
        return array[i-1] + sommaRicorsiva2(array, i-1);
    }

    // creiamo una funzione di appoggio che inizializza il secondo parametro utilizzando l'Overloading
    // altrimenti l'utilizzatore della funzione dovrebbe ogni volta scrivere "array.length" come secondo parametro
    // ma ancora più problematico è il fatto che potrebbe scrivere un valore diverso, rompendo così il corretto funzionamento
    public static int sommaRicorsiva2(int[] array) {
        return sommaRicorsiva2(array, array.length);
    }

}
