package esercizi.libreria_componibile;

public class Test {

    public static void main(String[] args) {
        Scaffale sc = new Scaffale(1);

        LibreriaComponibile lc = new LibreriaComponibile();
        lc.aggiungiScaffale(sc);
        sc.aggiungi(new Libro("Le filosofeggianti avventure di Pedro Pavard", "Pedro"));

        lc.aggiungiLibro(new Libro("Le filosofeggianti avventure 2", "Pedro"));

        for (Scaffale libro : lc) {
            System.out.println(libro);
        }
    }

}
