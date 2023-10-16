package module_07.src.esempi.lambda;

@FunctionalInterface
// potremo assegnare a StringProcessor qualunque lambda con un solo parametro di tipo String e un valore di ritorno di tipo String
public interface StringProcessor {

    String process(String s);

}
