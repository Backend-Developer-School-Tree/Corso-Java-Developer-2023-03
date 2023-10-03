package esercizi.lampadina.test;

import esercizi.lampadina.Impianto;
import esercizi.lampadina.Interruttore;
import esercizi.lampadina.Lampadina;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        // test();
        Lampadina lampadina = new Lampadina(10);
        Lampadina lampadina2 = new Lampadina(5);
        Lampadina lampadina3 = new Lampadina(5);
        Lampadina[] lampadine = {lampadina, lampadina2, lampadina3};
        Impianto impianto = new Impianto(true, lampadine);
        lampadina.click();
        System.out.println(lampadina.printStatus());
        impianto.setElectricity(false);
        System.out.println(lampadina.printStatus());
        lampadina.click();
        System.out.println(lampadina.printStatus());
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        Lampadina lampadina = new Lampadina(10);
        Interruttore interruttore1 = new Interruttore(lampadina);
        Interruttore interruttore2 = new Interruttore(lampadina);
        while(true) {
            System.out.println("Scegli quale interruttore premere! Inserisci 1 o 2, 0 per uscire");
            int next = scanner.nextInt();
            if (next == 1) {
                interruttore1.click();
                System.out.println(lampadina.printStatus());
            }
            else if (next == 2) {
                interruttore2.click();
                System.out.println(lampadina.printStatus());
            }
            else if (next == 0) {
                System.out.println("Grazie di aver giocato con la lampadina!");
                break;
            } else {
                System.out.println("input non valido!");
            }
        }
    }

}
