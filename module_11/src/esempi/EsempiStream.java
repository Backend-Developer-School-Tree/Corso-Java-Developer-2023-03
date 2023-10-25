package esempi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EsempiStream {

    public static void main(String[] args) throws IOException {
        System.out.println("***** ESEMPI STREAM *****");

        List<Integer> numeri = new ArrayList<>();
        numeri.add(5);
        numeri.add(8);
        numeri.add(12);
        numeri.add(0);
        numeri.add(-1);

        // 1) Voglio contare solo i numeri maggiori di 0
        // Soluzione imperativa
        int conteggioImperativo = 0;
        for(Integer n : numeri){
            if(n>0) conteggioImperativo++;
        }
        System.out.println(conteggioImperativo);

        // Soluzione dichiarativa / funzionale
        long conteggioDichiarativo = numeri.stream().filter(n -> n>0).count();
        System.out.println(conteggioDichiarativo);

        // 2) Stampare tutte le stringhe di un array
        String[] parole = {"Java","PHP","Python", "JavaScript"};
        Arrays.stream(parole).forEach(System.out::println);

        // 3) Massimo di un array. Nota il metodo max torna una classe Optional,
        // con il metodo get() prendo il valore dentro l'Optional
        int numeroMassimo = numeri.stream().max(Integer::compare).get();
        System.out.println(numeroMassimo);

        List<String> paroleList = Arrays.asList(parole);
        // 4) Stampo tutte le parole che iniziano con la maiuscola
        paroleList.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .forEach(System.out::println);
        // 5) Conto il numero di parole che iniziano con la maiuscola
        // due operazioni intermedie sono efficienti allo stesso modo,
        // in quanto le operazioni vengono effettuate insieme in maniera ottimizzata
        // e non sequenzialmente come faremmo con dei for in un programma imperativo
        long nParoleConMaiuscola = paroleList.stream()
                .map(s -> s.charAt(0))
                .filter(Character::isUpperCase)
                .count();

        // **** NOTA ****: quando lo stream diventa più complesso, con più di una operazione intermedia,
        // è consigliabile separarlo su più righe, anche per avere il suggerimento sul tipo che generiamo con map e simili

        // 6) Contare le righe di un file
        // analogamente al metodo .readAllLines che ritorna una List<String> abbiamo .lines che ritorna Stream<String>
        long nLines = Files.lines(Paths.get("module_11", "src", "esempi", "EsempiOptional.java")).count();

        // 7) Stampa tutte le righe di un file
        Files.lines(Paths.get("module_11", "src", "esempi", "EsempiOptional.java")).forEach(System.out::println);

        // 8) Stampare le parole ordinate
        // con le collection abbiamo il metodo sort che ordina gli elementi in-place e ritorna void
        // (quindi modifica gli elementi interni alla collection stessa)
        // paroleList.sort();
        System.out.println("------------------------------");
        System.out.println("Stampiamo l'array di parole ordinato grazie a sorted():");
        paroleList.stream().sorted().forEach(System.out::println);
        // il metodo sorted degli stream ritorna invece uno stream ordinato, senza side-effects sulla collection originale
        System.out.println();
        System.out.println("Verifichiamo che la lista originaria non sia stata modificata (ordinata)");
        System.out.println(paroleList);

        // 9) Possiamo creare una collection a partire da uno stream con .collect
        List<String> listaParoleOrdinata = paroleList.stream().sorted().collect(Collectors.toList());
        Set<String> setParole = paroleList.stream().collect(Collectors.toSet());

        // 10) Creare una lista ordinata senza duplicati (solamente con stream)
        List<String>  listaParoleOrdinataSenzaDuplicati = paroleList.stream()
                // .sorted() // sorted prima di un "casting" a set non avrebbe effetto perché gli insieme non sono ordinati
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .collect(Collectors.toList());

        // in maniera un po' più pulita:
        listaParoleOrdinataSenzaDuplicati = paroleList.stream().distinct().sorted().collect(Collectors.toList());

        // 11) Stampiamo solamente N righe di un file (non assumiamo che siano i primi N)
        Files.lines(Paths.get("module_11", "src", "esempi", "EsempiOptional.java")).limit(2).forEach(System.out::println);

        // 12) Salviamo tutte le stringhe in uppercase in una nuova lista
        List<String> paroleListUpperCase = paroleList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // 13) Aggiungiamo il 22% di iva a tutti i prezzi di una lista
        numeri.stream().map(n -> n*1.22).forEach(System.out::println);

        // 14) Concatenare le stringhe con un separatore es. [Java, PHP, Python, JavaScript] --> "Java-PHP-Python-JavaScript"
        String paroleConcatenate = paroleList.stream().collect(Collectors.joining("-"));
        // simile al metodo String.join("-", paroleList)

        // 15) Creare una mappa con chiavi il primo carattere e valori le stringhe stesse
        /*
        Map<Character, String> map = paroleList.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        Function.identity())); // Funciton.identity() == s -> s
         */
        // ATTENZIONE: la mappa avrà dei conflitti sulle chiavi, es. PHP e Python hanno la stessa chiave "P" e genererà una eccezione

        // possiamo risolvere analogamente a come facevamo utilizzando il metodo .merge al posto del metodo .put
        Map<Character, String> map = paroleList.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        Function.identity(),
                        (s, s2) -> s+","+s2     // {P=PHP,Python, J=Java,JavaScript}
                        ));

        // 16) Concateniamo le stringhe con un separatore (come in 14) utilizzando .reduce
        paroleConcatenate = paroleList.stream()
                .reduce((s1, s2) -> s1+"-"+s2)
                .get();


        // **** METODI DI RICERCA SUGLI ELEMENTI NELLO STREAM ****
        // anyMatch, noneMatch, allMatch, findFirst, ecc

        // 17) Verificare che un qualunque elemento sia maggiore di 5
        numeri.stream().anyMatch(n -> n > 5);

        // 18) Verificare che tutti gli elementi siano maggiori di 5
        numeri.stream().allMatch(n -> n > 5);

        // 19) Verifcare che nessun elemento sia maggiore di 5
        numeri.stream().noneMatch(n -> n > 5);

        // 20) Recuperare un qualunque elemento contenuto nello stream (o un optional se lo stream è vuoto)
        numeri.stream().findAny();

        // 21) Recuperare il primo elemento presente nello stream (ad esempio se abbiamo prima eseguito sorted sapremo quale aspettarci)
        numeri.stream().findFirst();

        List<List<String>> listDiListe = List.of(paroleList, List.of("parola1", "parola2"));
        // [[Java, PHP, Python, JavaScript], [parola1, parola2]]
        System.out.println(listDiListe);
        // 22) Creare una lista unica di stringhe a partire da una lista di liste di stringhe
        // es. [[Java, PHP, Python, JavaScript], [parola1, parola2]] --> [Java, PHP, Python, JavaScript, parola1, parola2]
        List<String> listFlat = listDiListe.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
