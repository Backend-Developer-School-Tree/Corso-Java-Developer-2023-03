package module_07.src.esempi.collections;

import java.util.*;

public class Esempi {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set = new TreeSet<>();
        set = new LinkedHashSet<>();

        // dobbiamo implementare equals e hascode
        Set<Word> wordSet = new HashSet<>();
        wordSet = new LinkedHashSet<>();
        // dobbiamo implementare Comparable (se non lo facciamo c'è un Warning ma mai un Errore a tempo di compilazione)
        wordSet = new TreeSet<>();
        // oppure passare un Comparator in input
        wordSet = new TreeSet<>(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWord().compareTo(o2.getWord());
            }
        });
        wordSet = new TreeSet<>((Word o1, Word o2) -> o1.getWord().compareTo(o2.getWord()));
        wordSet = new TreeSet<>(Comparator.comparing(o -> o.getWord()));
        wordSet = new TreeSet<>(Comparator.comparing(Word::getWord));

        Comparator<Word> cmp = (Word o1, Word o2) -> o1.getWord().compareTo(o2.getWord());


        // ***** MAPPE *****


        Map<Integer, Word> map = new HashMap<>();
        Set<Integer> s = map.keySet(); // insieme delle chiavi
        Collection<Word> c = map.values(); // lista dei valori (con duplicati)

        // iteriamo sull'insieme di chiavi
        for (Integer key : map.keySet()) {
            // recuperiamo il valore associato
            Word val = map.get(key);
        }

        Set<Map.Entry<Integer, Word>> entries = map.entrySet(); // coppie dei valori

        // iteriamo direttamente sulle coppie
        for (Map.Entry<Integer, Word> entry : entries) {
            entry.getKey();   // chiave della coppia
            entry.getValue(); // valore della coppia
        }

        Word word1 = new Word(1, "ciao");
        Word word2 = new Word(2, "ciao");
        map.put(word1.getId(), word1);
        map.put(word2.getId(), word2);
        map.put(2, new Word(2, "hello"));

        // merge fa un put in cui se abbiamo duplicati "uniamo" i valori secondo la funzione
        map.merge(word2.getId(), word2, (w1, w2) -> new Word(w1.getId(), w1.getWord() + ";" + w2.getWord()));

        /*
        // come se a mano facessimo
        if (map.containsKey(word2.getId())) {
            map.get(word2.getId());
            Word newWord = new Word(w1.getId(), w1.getWord() + ";" + word2.getWord());
            map.put(word2.getId(), newWord);
        }
         */

        System.out.println(map);
    }
}
