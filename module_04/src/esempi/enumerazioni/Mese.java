package esempi.enumerazioni;

import java.util.Arrays;

public enum Mese {

    // GEN(1), FEB(2), MAR(3), APR(4), MAG(5), GIU(6), LUG(7), AGO(8), SET(9), OTT(10), NOV(11), DIC(12);
    // possiamo scrivere gli enum su una singola riga o su più righe (per migliore leggibilità quando abbiamo molti valori)

    GEN(1),
    FEB(2),
    MAR(3),
    APR(4),
    MAG(5),
    GIU(6),
    LUG(7),
    AGO(8),
    SET(9),
    OTT(10),
    NOV(11),
    DIC(12);

    private final int numeric;

    Mese(int numeric) {
        this.numeric = numeric;
    }

    @Override
    public String toString() {
        return "Mese{" +
                "name=" + this.name() +
                ", ordinal=" + this.ordinal() +
                ", numeric=" + numeric +
                '}';
    }

    public static void main(String[] args) {
        Mese mese = Mese.GEN;
        // come se stessimo istanziando un'eventuale classe Mese
        // Mese mese = new Mese("GEN");
        System.out.println(mese);

        // .values() è un metodo statico di ogni classe enum
        // che restituisce un array con tutti gli oggetti (le costanti) definiti in essa
        System.out.println(Arrays.toString(Mese.values()));

        // .valueOf(String str) è un metodo statico di ogni classe enum
        // che a partire dal "nome" (la versione stringa) di una delle costanti definite nell'enum
        // restituisce l'istanza effettiva dell'oggetto enum
        Mese mese2 = Mese.valueOf("FEB"); // Mese.FEB
        System.out.println(mese2);

        // .ordinal() è un metodo che ritorna l'indice associato all'istanza dell'enum
        // in base all'ordine con cui è definito, partendo da 0 per il primo come per gli array
        System.out.println(mese2.ordinal());
        System.out.println(Mese.values()[mese2.ordinal()]);

        // .name() è un metodo che ritorna la rappresentazione in versione stringa del nome della costante enum
        System.out.println(Mese.GEN.name());
    }
}
