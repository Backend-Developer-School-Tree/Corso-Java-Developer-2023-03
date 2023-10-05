package esercizi.biblioteca;

import java.util.Arrays;
import java.util.Comparator;

public class Biblioteca {

    private Libro[] libri;

    Biblioteca(Libro[] libri) {
        this.libri = libri;
    }

    private boolean esisteLibro(int indice) {
        for (Libro libro : libri) {
            if (libro.getIndex() == indice)
                return true;
        }
        return false;
    }

    private boolean esisteLibro(Libro libro) {
        return esisteLibro(libro.getIndex());
    }

    private Libro[] getLibriOrdinati() {
        Arrays.sort(libri, Comparator.comparing(s -> s.getIndex())); // Comparator.comparing(Libro::getIndex));
        return libri;
    }

    private int[] getIndiciLibriOrdinati() {
        int[] indici = new int[libri.length];

        for (int i = 0; i < getLibriOrdinati().length; i++) {
            indici[i] = libri[i].getIndex();
        }

        return indici;
    }

    public static void main(String[] args) {
        Libro[] books = new Libro[]{
                new Libro(123, "Luciana Litizzetto", "I dolori del giovane Programmatore"),
                new Libro(2, "Super Mario", "Errori da non ripetere"),
                new Libro(98, "Luigi Pirandino", "Uno, nessuno e diecimila bug"),
                new Libro(33, "Roberto Roberti", "Come programmare in Java da zero"),
                new Libro(76, "Piero Java", "Mille splendidi errori"),
                new Libro(2, "Lavinia Pitoni", "Non si esce vivi dalle biblioteche"),
                new Libro(235, "Luciana Litizzetto Jr.", "I dolori del vecchio Programmatore")
        };

        Biblioteca library = new Biblioteca(books);
        // System.out.println(library.esisteLibro(76));

        /*
        Libro[] booksInLibrary = library.getLibriOrdinati();
        System.out.println(booksInLibrary[0].getIndex() == 2);
        System.out.println(booksInLibrary[1].getIndex() == 4);
        System.out.println(booksInLibrary[2].getIndex() == 33);
        System.out.println(booksInLibrary[3].getIndex() == 76);
        System.out.println(booksInLibrary[4].getIndex() == 98);
        System.out.println(booksInLibrary[5].getIndex() == 123);
        System.out.println(booksInLibrary[6].getIndex() == 235);
         */

        System.out.println(Arrays.toString(books));
        // ordinamento tramite la logica definita nel metodo compareTo della classe Libro
        Arrays.sort(books);
        System.out.println(Arrays.toString(books));
    }
}
