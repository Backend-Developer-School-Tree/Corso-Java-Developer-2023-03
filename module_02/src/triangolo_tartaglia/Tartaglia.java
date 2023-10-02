package triangolo_tartaglia;

import java.util.Arrays;

public class Tartaglia {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(calcolaRigaTartaglia(5)));
        System.out.println(Arrays.toString(calcolaRigaTartaglia(6)));
    }

    public static int[] calcolaRigaTartaglia(int n) {
        // CASI BASE
        if (n == 1) return new int[]{1};
        if (n == 2) return new int[]{1,1};

        // CASO RICORSIVO (n >= 3)

        // calcoliamo la precedente riga del triangolo di tartaglia (n-1)
        int[] previousRow = calcolaRigaTartaglia(n-1);

        // inizializziamo la nuova riga del triangolo di tartaglia
        int[] nextRow = new int[previousRow.length + 1];
        // il primo e l'ultimo elemento di ogni riga sono sempre uguali a 1
        nextRow[0] = 1;
        // i valori di mezzo vanno generati in base alla riga precedente
        nextRow[nextRow.length-1] = 1;

        // calcoliamo gli altri elementi in base a quelli della riga precedente
        for (int i = 0; i < previousRow.length-1; i++) {
            nextRow[i + 1] = previousRow[i] + previousRow[i + 1];
        }

        return nextRow;
    }

}
