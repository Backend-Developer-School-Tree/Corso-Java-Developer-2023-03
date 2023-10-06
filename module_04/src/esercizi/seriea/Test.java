package esercizi.seriea;

public class Test {

    public static void main(String[] args) {
        // creo 5 giocatori
        Giocatore giocatore1 = new Giocatore("Leo", "Messi");
        Giocatore giocatore2 = new Giocatore("Luka", "Modric");
        Giocatore giocatore3 = new Giocatore("Lautaro", "Martinez");
        Giocatore giocatore4 = new Giocatore("Romelu", "Lukaku");
        Giocatore giocatore5 = new Giocatore("Federico", "Chiesa");

        // creo una rosa
        Giocatore[] rosa1 = {giocatore1, giocatore2, giocatore3};

        // creo 3 squadre
        Team team1 = new Team("Herta Vernello", rosa1, 0, 0, 0);
        Team team2 = new Team("Birrareal");
        Team team3 = new Team("Squadra Genew");

        // aggiungo giocatori in rosa nel team 2
        team2.addPlayer(giocatore4);
        team2.addPlayer(giocatore5);

        // stampo le rose del team1 e del team2
        team1.printRosa();
        System.out.println();
        team2.printRosa();
        System.out.println("-------------");

        //rimuovo un giocatore dalla rosa del team1 e provo a ristampare
        team1.removePlayer(giocatore1);
        team1.printRosa();
        System.out.println("-------------");

        // creo il campionato
        Team[] campionato = { team1, team2, team3 };
        Classifica classifica = new Classifica(campionato);
        Team team4 = new Team("AS Roma");
        classifica.addTeam(team4);
        System.out.println(classifica);
        System.out.println("----------------");

        // gioco delle partite
        classifica.esitoPartita(team1, team2, 3, 2);
        classifica.esitoPartita(team3, team4, 1, 1);
        classifica.esitoPartita(team4, team1, 2, 0);
        classifica.esitoPartita(team2, team3, 1, 2);
        classifica.esitoPartita(team3, team1, 3, 1);
        classifica.esitoPartita(team2, team4, 2, 2);

        // testo i metodi
        classifica.getClassifica();
        System.out.println(classifica);
        System.out.println("MIGLIOR ATTACCO: " + classifica.miglioreAttacco());
        System.out.println("PEGGIOR DIFESA: " + classifica.peggiorDifesa());





    }

}
