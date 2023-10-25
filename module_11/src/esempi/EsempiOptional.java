package module_11.src.esempi;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EsempiOptional
{
    // Optional è una classe che serve come "contenitore" di un riferimento che potrebbe essere null o non essere null
    // utilizziamo gli Optional ad esempio come tipo di ritorno di un metodo per cui potrebbe tornare null

    // analogamente a come una List è un contenitore che può essere vuoto (0 elementi) o meno (N elementi)
    // Optional è un contenitore che può essere vuoto (nessun elemento) o meno (1 elemento)
    // nessuno dei due oggetti dovrebbe mai essere null!!

    public record User(String nome, String cognome) {}

    private Map<String, User> map = new HashMap<>();

    public Optional<User> getUser(int nome) {
        Optional<User> optUser = Optional.empty();

        if (map.containsKey(nome)) optUser = Optional.of(map.get(nome));

        return optUser;
        // return map.containsKey(nome) ? Optional.of(map.get(nome)) : Optional.empty();
    }

    public User getUserSenzaOptional(int nome) {
        User user = null;

        if (map.containsKey(nome)) user = map.get(nome);

        return user;
        // return map.containsKey(nome) ? map.get(nome) : null;
    }

    public static void main(String[] args) {
        String str = null;

        if (str != null) str.toLowerCase();

        // **** CREAZIONE DI UN OGGETTO OPTIONAL ****

        // senza nessun valore al suo interno
        // ad esempio al posto del return null a fine metodo
        Optional<String> optEmpty = Optional.empty();
        // con un valore NON nullo
        // ad esempio se abbiamo appena creato un oggetto e siamo sicuri non sarà null
        Optional<String> optConValore = Optional.of("valore");
        // con un valore che può essere null
        // ad esempio se il valore viene dall'esterno o non siamo sicuri sia definito
        Optional<String> optConValoreNullable = Optional.ofNullable(str);

        // il metodo .of genera NullPointerException se passiamo un valore null
        // Optional.of(null);
        // quando non sappiamo se l'oggetto è null o meno utilizzamo .ofNullable
        Optional.ofNullable(null);


        // **** METODI DELLA CLASSE OPTIONAL ****

        if (optEmpty.isPresent()) // se c'è un valore all'interno dell'Optional
            System.out.println(optEmpty.get()); // estraiamo il valore dall'Optional con il metodo get

        if (optEmpty.isEmpty())
            optEmpty = Optional.of("valore");

        // se non è presente alcun valore nell'Optional, il metodo get solleverà un'eccezione NoSuchElementException
        // è quindi importante sempre prima verificare se sia vuoto o meno con i metodi .isPresent o .isEmpty
        // optEmpty.get();

        // in alternativa possiamo utilizzare i metodi .orElse o .ifPresent
        // orElse esegui il get, se il valore non è presente restituisce quello passato come parametro --> "valore"
        optEmpty.orElse("valore");
        optEmpty.orElseGet(() -> "valore");

        // ifPresent esegui il get, se il valore è presente esegue la lambda passata come parametro
        optEmpty.ifPresent(value -> System.out.println(value));
        optConValore.ifPresent(System.out::println);
        optConValoreNullable.ifPresent(System.out::println);
    }
}
