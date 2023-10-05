package esempi.persona;

public class Studente extends Persona {

    private String matricola;

    public Studente(String name) {
        super(name); //Richiamo costruttore classe super di Persona
    }

    @Override
    public void sayMyName(){
        super.sayMyName();
        System.out.println("Sono uno studente");
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }
}
