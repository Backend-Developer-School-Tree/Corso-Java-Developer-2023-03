package esercizi.anagrammi;

import java.util.Arrays;

public class Anagrammi {

    /*
    Due stringhe a e b sono dette anagrammi
    se contengono gli stessi caratteri con le stesse frequenze.
    Ad esempio, gli anagrammi di CAT sono CAT, ACT, TAC, TCA, ATC, e CTA.
    Date due stringhe a e b in input, stampare «anagrammi» se sono anagrammi
    (case-insensitive), «non anagrammi» altrimenti.
     */
    public static void anagrammi(String a, String b) {
        if (a.length() != b.length()) {
            System.out.println("non anagrammi");
            return;
        }
        char[] chars_a = a.toLowerCase().toCharArray();
        char[] chars_b = b.toLowerCase().toCharArray();
        Arrays.sort(chars_a);
        Arrays.sort(chars_b);
        if (Arrays.equals(chars_a, chars_b)) {
            System.out.println("Anagrammi!");
        }
        else System.out.println("non anagrammi");

    }

    public static String anagrams(String A, String B){
        String a = A.toLowerCase();
        String b = B.toLowerCase();
        if (a.length()!=b.length())
            return a + " e " + b + " non sono anagrammi";

        int[] countA = new int[a.length()];
        int[] countB = new int[b.length()];
        for(int i=0; i<a.length(); i++){
            for(int j=0; j<b.length(); j++){
                if (a.charAt(i)==b.charAt(j) && countB[j]==0) {
                    countB[j] = 1;
                    countA[i] = 2;
                    break;
                }
            }
            System.out.println("Array A: " + Arrays.toString(countA));
            System.out.println("Array B: " + Arrays.toString(countB));
            if (countA[i]==0) return a + " e " + b + " non sono anagrammi";
            System.out.println("--------------");
        }
        return a + " e " + b + " sono anagrammi";
    }

}
