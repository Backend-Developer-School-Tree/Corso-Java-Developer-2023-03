package esercizi.libreria_componibile;

public class Libro {

    private String titolo;
    private String autore;
    private boolean letto = false;

    public Libro(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public void setLetto() { letto = true; }

    public boolean letto() { return letto; }

    public String getTitolo() { return titolo; }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", letto=" + letto +
                '}';
    }
}
