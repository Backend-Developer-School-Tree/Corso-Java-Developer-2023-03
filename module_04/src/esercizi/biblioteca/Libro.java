package esercizi.biblioteca;

public class Libro implements Comparable<Libro> {
    private int index;
    private String nome;
    private String autore;
    // ...

    public Libro(int index, String nome, String autore) {
        this.index = index;
        this.nome = nome;
        this.autore = autore;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public int compareTo(Libro libro) {
        /*
        // per comparare due oggetti dello stesso tipo dobbiamo ritornare un intero (negativo, positivo o 0)
        if (this.getIndex() == libro.getIndex())
            return 0; // quando il nostro oggetto (this) è "uguale" al libro passato come parametro
        else if (this.getIndex() < libro.getIndex())
            return -1; // (qualunque valore negativo) quando il nostro oggetto (this) è "più piccolo" del libro passato come parametro
        else // if (this.getIndex() > libro.getIndex())
            return 1; // (qualunque valore positivo) quando il nostro oggetto (this) è "più grande" del libro passato come parametro
         */

        // comparazione analoga su una sola riga utilizzando l'operatore ternario
        // return this.getIndex() == libro.getIndex() ? 0 : this.getIndex() < libro.getIndex() ? -1 : 1;

        // modo più standard e pulito per comparare un singolo campo
        // return Integer.compare(this.getIndex(), libro.getIndex());

        // e se volessimo comparare in base a più di un attributo?
        // ad esempio per ordinare prima in base all'index e in caso di uguaglianza anche in base all'autore
        int indexComparison = Integer.compare(this.getIndex(), libro.getIndex());

        // se gli index sono uguali
        if (indexComparison == 0)
            // ordina in base al nome
            return this.nome.compareTo(libro.nome);
        else
            // altrimenti ordina solo in base all'index
            return indexComparison;
    }
}
