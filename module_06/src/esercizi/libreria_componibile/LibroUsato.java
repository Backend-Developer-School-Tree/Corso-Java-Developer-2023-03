package esercizi.libreria_componibile;

public class LibroUsato extends Libro {

    public LibroUsato(String titolo, String autore) {
        super(titolo, autore);
        setLetto();
    }
}
