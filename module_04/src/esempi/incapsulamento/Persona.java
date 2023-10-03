package esempi.incapsulamento;

public class Persona {

    // attributi
    public static final double pigreco = Math.PI;
    private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        if (eta >= 0) this.eta = eta;
        else System.out.println("Errore età negativa!");
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        if (eta >= 0) this.eta = eta;
        else System.out.println("Errore età negativa!");
    }
}
