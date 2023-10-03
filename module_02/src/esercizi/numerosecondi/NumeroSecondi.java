package esercizi.numerosecondi;

public class NumeroSecondi {

    /*
    Scrivete una funzione che dato in input un numero di secondi,
    restituisce una stringa che dice
    «Giorni: numero di giorni, Ore: numero di ore etc…»
     */
    public static String calcoloSecondi(int secondi) {
        // calcolo i giorni
        int giorni = secondi / 86400;
        secondi = secondi % 86400;
        // calcolo le ore
        int ore = secondi / 3600;
        secondi = secondi % 3600;
        // calcolo i minuti
        int minuti = secondi / 60;
        secondi = secondi % 60;
        return "Giorni: " + giorni + ", Ore: " + ore + ", Minuti: "
                + minuti + ", Secondi: " + secondi;
    }

}
