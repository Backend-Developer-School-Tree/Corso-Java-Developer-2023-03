package operazioni_aritmetiche;

import java.util.Scanner;

public class OperazioniAritmetiche {

    /*
    Scrivere un programma Java che permetta all’utente di inserire due numeri interi e,
    successivamente, stampi a video il risultato di addizione, sottrazione, moltiplicazione
    e divisione tra i due numeri.
     */
    public static void operazioniAritmetiche() {
        // definisco lo scanner e prendo i due numeri dall'utente
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci due numeri!");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        // stampo le varie operazioni
        int somma = num1 + num2;
        System.out.println("Il risultato della somma è: " + somma);
        int sottrazione = num1 - num2;
        System.out.println("Il risultato della sottrazione è: " + sottrazione);
        int moltiplicazione = num1 * num2;
        System.out.println("Il risultato della moltiplicazione è: " + moltiplicazione);
        if (num2 == 0) {
            System.out.println("Non si può dividere per zero!");
            return;
        }
        double divisione = (double) num1 / (double) num2;
        System.out.println("il risultato della divisione è: " + divisione);
    }

}
