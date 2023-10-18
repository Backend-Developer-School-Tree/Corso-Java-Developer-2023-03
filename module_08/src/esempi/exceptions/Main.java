package esempi.exceptions;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Gestione eccezioni in Java ***");

        // NOTA: variabile myArray non visibile fuori dal blocco try-catch
        try {
            int[] myArray = {1, 2, 3}; //myArray non visibile fuori da queste graffe
            //System.out.println(myArray[4]);

            //In caso di potenziali eccezioni multiple, conta l'ordine
            String inputFromUser = "42";
            myArray[50] = Integer.valueOf(inputFromUser);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Eccezione dentro il primo catch");
            System.out.println(e.getMessage()); //Cosa ha causato l'errore

            //e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Eccezione dentro il secondo catch");
            System.out.println(e.getMessage()); //Cosa ha causato l'errore
        } catch (Exception e) {
            System.out.println("Eccezione dentro il primo catch");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Rilascio risorse");
        }

        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Eccezione età non valida");
        }

        System.out.println("*** Fine gestione eccezioni in Java ***");
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Età minima 18 anni");
        } else
            System.out.println("Età verificata con successo");
    }
}