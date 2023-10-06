package esempi.incapsulamento;

public class Persona {

    // attributi
    private static int idTot = 0;
    private int id;
    private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) {
        idTot++;
        this.id = idTot;
        this.nome = nome;
        this.cognome = cognome;
        if (eta >= 0) this.eta = eta;
        else System.out.println("Errore età negativa!");
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public static int getIdTot() {
        return idTot;
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        if (eta >= 0) this.eta = eta;
        else System.out.println("Errore età negativa!");
    }
}
