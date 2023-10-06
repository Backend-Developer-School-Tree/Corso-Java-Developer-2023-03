package esercizi.seriea;

public class Classifica {

    private Team[] championship;

    public Classifica(Team[] championship) {
        this.championship = championship;
    }

    public Classifica() {
        this.championship = new Team[0];
    }

    public Team[] getChampionship() {
        return championship;
    }

    public void setChampionship(Team[] championship) {
        this.championship = championship;
    }

    /**
     * Questo metodo aggiunge una squadra al campionato
     * @param t un Team
     */
    public void addTeam(Team t) {
        Team[] tmp = new Team[championship.length+1];
        for (int i = 0; i < championship.length; i++) {
            tmp[i] = championship[i];
        }
        tmp[championship.length] = t;
        championship = tmp;
        tmp = new Team[0];
    }

    /**
     * Questo metodo rimuove un team dal campionato. Se il team
     * non è presente stampa un messaggio di errore.
     * @param t il team da rimuovere
     */
    public void removeTeam(Team t) {
        Team[] tmp = new Team[championship.length-1];
        int index = -1;
        for (int i = 0; i < championship.length; i++) {
            if (championship[i] == t) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("ERRORE! Team non trovato");
        }
        else {
            for (int i = 0; i < index; i++) {
                tmp[i] = championship[i];
            }
            for (int i = index; i < tmp.length; i++) {
                tmp[i] = championship[i+1];
            }
            championship = tmp;
            tmp = new Team[0];
        }
    }
}
