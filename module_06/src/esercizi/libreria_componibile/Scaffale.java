package esercizi.libreria_componibile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Scaffale implements Iterable<Libro> {

    private List<Libro> libri = new ArrayList<>();
    private final int capienzaMassima;

    public Scaffale(int capienzaMassima) {
        this.capienzaMassima = capienzaMassima;
    }

    public Scaffale(int capienzaMassima, Libro... libri) {
        this(capienzaMassima);

        this.libri.addAll(Arrays.asList(libri));
    }

    public boolean capienzaRaggiunta() { return capienzaMassima <= libri.size(); }

    public boolean aggiungi(Libro libro) {
        if (capienzaRaggiunta()) return false;

        return libri.add(libro);
    }

    public void aggiungi(Libro... libri) {
        for (Libro libro : libri) {
            aggiungi(libro);
        }
    }

    public boolean rimuovi(Libro libro) { return libri.remove(libro); }

    public List<Libro> cercaPerTitolo(String titolo) {
        List<Libro> libriMatchTitolo = new ArrayList<>();

        for (Libro libro : libri) {
            if (libro.getTitolo().equals(titolo))
                libriMatchTitolo.add(libro);
        }

        return libriMatchTitolo;
    }

    // TODO cercare per titolo solo i non letti

    public List<Libro> getLibriNonLetti() {
        List<Libro> libriNonLetti = new ArrayList<>();

        for (Libro libro : libri) {
            if (!libro.letto())
                libriNonLetti.add(libro);
        }

        return libriNonLetti;
    }

    @Override
    public String toString() {
        return "Scaffale{" +
                "libri=" + libri +
                ", capienzaMassima=" + capienzaMassima +
                '}';
    }

    @Override
    public Iterator<Libro> iterator() {
        return new Iterator<Libro>() {
            int indice = 0;

            @Override
            public boolean hasNext() {
                return indice != libri.size();
            }

            @Override
            public Libro next() {
                return libri.get(indice++);
            }
        };
    }
}
