package esempi.persona;

public class Persona {

    protected String name;

    public Persona(String name) {
        this.name = name;
    }

    public void sayMyName(){
        System.out.println("Sono una persona");
    }

    @Override
    public String toString() {
        return "Persona{name='" + name + "'}";
    }
}
