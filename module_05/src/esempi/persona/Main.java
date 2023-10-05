package esempi.persona;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Davide");

        p1.sayMyName();
        System.out.println(p1);

        Studente s1 = new Studente("Anna");
        s1.sayMyName();

        Professore pr1 = new Professore("Giacomo");
        pr1.sayMyName();
    }
}