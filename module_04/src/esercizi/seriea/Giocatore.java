package esercizi.seriea;

public class Giocatore {

    private static int idTot = 0;
    private int id;
    private String nome;
    private String cognome;

    public Giocatore(String nome, String cognome) {
        this.id = idTot;
        idTot++;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
