package esercizi.vocali_consonanti;

public class VocaliConsonanti {

    /*
    Scrivete un programma che data una parola stampa a schermo il numero di vocali e
    consonanti presenti.
    Modificate il programma in modo che funzioni con una frase data. (usate le funzioni).
     */
    public static void stampaVocaliConsonanti(String s) {
        s = s.toLowerCase();
        int vocali = 0;
        int consonanti = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                if (ch.equals('a') || ch.equals('e') || ch.equals('i')
                    || ch.equals('o') || ch.equals('u')) {
                    vocali++;
                }
                else consonanti++;
            }
        }
        System.out.println("Il numero di vocali in " + s + " è " + vocali);
        System.out.println("Il numero di consonanti in " + s + " è " + consonanti);
    }

}
