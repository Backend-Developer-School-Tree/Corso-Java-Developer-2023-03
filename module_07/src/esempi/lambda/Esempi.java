package module_07.src.esempi.lambda;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Esempi {

    // metodo che accetta una stringa e una funzione da applicare su di essa che ritorna un valore intero
    private static Integer applyFunctionOnString(String s, Function<String, Integer> processor) {
        return processor.apply(s);
    }

    public static void main(String[] args) {
        Function<String, Integer> fun = s -> Integer.parseInt(s);
        Function<String, Integer> fun2 = Integer::parseInt;

        applyFunctionOnString("5", fun);





        // Espressione a due parametri String con tipo di ritorno String
        BiFunction<String, String, String> biFun = (w1, w2) -> w1 + w2;


        // Espressione che prende in input un valore String e lo stampa senza ritornare nulla (void)
        Consumer<String> con = s -> System.out.println(s);
        con.accept("ciao");


        // Espressione senza argomenti che restituisce il valore 50
        Supplier<Integer> supp = () -> 50;





        // functional interface StringProcessor definita da noi
        // che accetta qualunque lambda con un solo parametro di tipo String e un valore di ritorno di tipo String
        StringProcessor sp = (String s) -> s.toLowerCase();
        StringProcessor sp2 = String::toLowerCase;

        // come se stessimo fornendo l'implementazione del metodo process
        System.out.println(sp.process("TEST"));

        // essenzialmente equivalente a Function<String, String> con il metodo apply
        Function<String, String> fsp = (String s) -> s.toLowerCase();
        System.out.println(fsp.apply("TEST"));
    }

}
