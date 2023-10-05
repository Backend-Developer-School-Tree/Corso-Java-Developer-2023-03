# Biblioteca 🛴

Scrivere un programma che permetta di gestire una Biblioteca semplificata, in grado di gestire un array
dei libri che contiene. La Biblioteca può essere creata a partire da un array di libri.
In particolare, implementare almeno i seguenti metodi:
- `esisteLibro`: prende l'indice di un libro e restituisce true se nella biblioteca esiste un libro con questo indice, false altrimenti
- `getLibriOrdinati`: ritorna la lista di libri presenti nella biblioteca, in ordine ascendente

Potete utilizzare il seguente codice come test:

```java
public class Main {
    public static void main(String[] args) {
        Libro[] books = new Libro[]{
                new Libro(123, "Luciana Litizzetto", "I dolori del giovane Programmatore"),
                new Libro(4, "Super Mario", "Errori da non ripetere"),
                new Libro(98, "Luigi Pirandino", "Uno, nessuno e diecimila bug"),
                new Libro(33, "Roberto Roberti", "Come programmare in Java da zero"),
                new Libro(76, "Piero Java", "Mille splendidi errori"),
                new Libro(2, "Lavinia Pitoni", "Non si esce vivi dalle biblioteche"),
                new Libro(235, "Luciana Litizzetto Jr.", "I dolori del vecchio Programmatore")
        };

        Biblioteca library = new Biblioteca(books);
        System.out.println(library.esisteLibro(76));

        Libro[] booksInLibrary = library.getLibriOrdinati();
        System.out.println(booksInLibrary[0].getIndex() == 2);
        System.out.println(booksInLibrary[1].getIndex() == 4);
        System.out.println(booksInLibrary[2].getIndex() == 33);
        System.out.println(booksInLibrary[3].getIndex() == 76);
        System.out.println(booksInLibrary[4].getIndex() == 98);
        System.out.println(booksInLibrary[5].getIndex() == 123);
        System.out.println(booksInLibrary[6].getIndex() == 235);
    }
}
```

Sarà perciò necessario creare anche una classe Libro con delle proprie caratteristiche, tra cui ad esempio, un indice,
nome, autore, categoria, ecc.

NOTA: l'ordinamento dei libri può essere implementato da zero (ad esempio implementando il [selection sort](https://en.wikipedia.org/wiki/Selection_sort)
o l'[insertion sort](https://en.wikipedia.org/wiki/Insertion_sort)) o fatto in maniera più smart con un Comparator,
che però vedremo dal modulo 6 in poi (in generale, una volta che si va avanti con i moduli del corso è consigliabile
tornare su gli esercizi per migliorarli, sfruttando le nuove conoscenze).

```Java
// dato un array di oggetti di tipo Libro (Libro[] books), i quali contengono un metodo getIndex
// possiamo ordinarlo in base all'index con Arrays.sort, aggiungendo il seguente Comparator come secondo parametro
Arrays.sort(books, Comparator.comparing(l -> l.getIndex()); // (Libro::getIndex));
```





