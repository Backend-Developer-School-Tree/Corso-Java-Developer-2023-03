package esempi.incapsulamento;

public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona("Marco", "Adriani", 30);
        System.out.println("Il nome e il cognome della persona sono: " +
                persona.getNome() + " " + persona.getCognome());
        persona.setNome("Ciccio");
        System.out.println("Il nome e il cognome della persona sono: " +
                persona.getNome() + " " + persona.getCognome());
        persona.setEta(-23);
        System.out.println("L'età della persona è: " + persona.getEta());
        Persona persona2 = new Persona("Antonio", "Rossi", -40);
        persona2.setEta(-40);
        System.out.println(persona2.getEta());
        System.out.println(persona.getId());
        System.out.println(persona2.getId());


    }

}
