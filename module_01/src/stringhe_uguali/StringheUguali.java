package stringhe_uguali;

public class StringheUguali {

    /*
    Date tre stringhe a, b e c in input, stampare l’intero corrispondente al numero di
    stringhe uguali tra loro (ignorando maiuscole e minuscole). Esempio: se a, b e c
    sono uguali tra loro stamperà «3», se invece a e b sono uguali ma c è diversa stamperà 2 etc.
     */
    public static void stampaStringheUguali(String a, String b, String c) {
        // consideriamo il caso che siano tutte uguali
        // equalsIgnoreCase è come equals ma non considera la differenza maiuscola-minuscola
        if (a.equalsIgnoreCase(b) && b.equalsIgnoreCase(c)) {
            System.out.println("Il numero di stringhe uguali è 3");
        }
        else if (a.equalsIgnoreCase(b) || b.equalsIgnoreCase(c) || a.equalsIgnoreCase(c)) {
            System.out.println("Il numero di stringhe uguali è 2");
        }
        else System.out.println("Il numero di stringhe uguali è 0");
    }


}
