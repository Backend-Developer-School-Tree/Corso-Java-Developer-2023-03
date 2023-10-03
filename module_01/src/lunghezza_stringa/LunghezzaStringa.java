package lunghezza_stringa;

import java.util.Scanner;

public class LunghezzaStringa {

    /* Scrivere un metodo che chieda all'utente di inserire una stringa.
     Se la stringa è più lunga di 10 caratteri ritorniamo "STRINGA LUNGA",
     altrimenti ritorniamo "STRINGA CORTA".

     sintassi di un metodo:
     modificatore_di_visibilità altri_modificatori tipo_ritorno nome_metodo(tipo1 par1, tipo2 par2,..., tipoN parN)
     */
    public static String lunghezzaStringa() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("ciao! Inserisci una stringa");
        String stringaInserita = myScanner.nextLine();
        if (stringaInserita.length() > 10) {
            return "STRINGA LUNGA";
        }
        return "STRINGA CORTA";
    }

    public static String reverseString(String frase) {
        String[] s = frase.split(" ");
        s[1] += " ";
        return s[1] + s[0];
    }
}
