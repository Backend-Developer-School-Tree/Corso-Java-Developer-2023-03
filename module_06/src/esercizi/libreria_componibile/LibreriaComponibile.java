package esercizi.libreria_componibile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibreriaComponibile implements Iterable<Scaffale> {

    private List<Scaffale> scaffali = new ArrayList<>();

    public boolean aggiungiLibro(Libro libro) {
        for (Scaffale scaffale : scaffali) {
            if (!scaffale.capienzaRaggiunta())
                return scaffale.aggiungi(libro);
        }

        return false;
    }

    public boolean aggiungiScaffale(Scaffale scaffale) { return scaffali.add(scaffale); }

    public boolean rimuoviScaffale(Scaffale scaffale) { return scaffali.remove(scaffale); }

    public Scaffale getScaffale(int indice) { return scaffali.get(indice); }

    public int size() { return scaffali.size(); }

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

    @Override
    public Iterator<Scaffale> iterator() {
        return new Iterator<>() {
            int indice = 0;

            @Override
            public boolean hasNext() {
                return indice != size();
            }

            @Override
            public Scaffale next() {
                return scaffali.get(indice++);
            }
        };
    }
}
