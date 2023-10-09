package esempi.comparator;

import java.util.Arrays;
import java.util.Comparator;

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

    /**
     * Questo metodo controlla se il Team passato in input
     * faccia parte del campionato.
     * @param t il Team da cercare
     * @return true se t è presente nel campionato, false altrimenti
     */
    public boolean isPresent(Team t) {
        for (Team team : championship) {
            if (t == team) return true;
        }
        return false;
    }

    public void esitoPartita(Team inCasa, Team inTrasferta, int golCasa, int golTrasferta) {
        if (!isPresent(inCasa) || !isPresent(inTrasferta)) {
            System.out.println("ERRORE! Una delle squadre (o entrambe!) non partecipano al campionato");
            return;
        }
        if (golCasa > golTrasferta) {
            inCasa.vittoria(golCasa, golTrasferta);
            inTrasferta.sconfitta(golTrasferta, golCasa);
        }
        else if (golCasa == golTrasferta) {
            inCasa.pareggio(golCasa);
            inTrasferta.pareggio(golCasa);
        }
        else {
            inCasa.sconfitta(golCasa, golTrasferta);
            inTrasferta.vittoria(golTrasferta, golCasa);
        }
    }

    /**
     * Questo metodo ritorna la classifica aggiornata e ordinata
     * per punteggio (e differenza reti).
     * @return la classifica ordinata
     */
    public Team[] getClassifica() {
        // ordinamento di default dei Team
        // lessicografico in base al nome (come definito in Comparable di Team)
        Arrays.sort(championship);

        // ordinamento in classifica per punteggio
        // con classe top-level Comparator
        Arrays.sort(championship, new TeamInClassificaComparator());

        // con classe innestata Comparator
        Arrays.sort(championship, new Classifica.TeamComparator());

        // con classe anonima
        Arrays.sort(championship, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                if (t1.getPunteggio() == t2.getPunteggio()) {
                    return -((t1.getGolFatti()-t1.getGolSubiti()) - (t2.getGolFatti() - t2.getGolSubiti()));
                }
                return -(t1.getGolFatti() - t2.getPunteggio());
            }
        });

        // con espressioni lambda e riferimenti a metodo (argomenti dei prossimi moduli)

        Arrays.sort(championship, Comparator.comparing((Team t) -> -t.getPunteggio())
                .thenComparing((Team t) -> -t.getGolFatti())
                .thenComparing((Team t) -> -t.getGolSubiti()));

        Arrays.sort(championship, Comparator.comparing(Team::getPunteggio)
                .thenComparing(Team::getGolFatti)
                .thenComparing(Team::getGolSubiti)
                .reversed());

        return championship;
    }

    @Override
    public String toString() {
        String s = "Team, punti, gol_fatti, gol_subiti" + "\n";
        for (Team t : championship) {
            s += t.toString() + "\n";
        }
        return s;
    }

    /**
     * Ritorna il Team con il migliore attacco del campionato.
     * @return un team t
     */
    public Team miglioreAttacco() {
        if (championship.length == 0) {
            System.out.println("Errore! Campionato vuoto");
            return null;
        }
        Team max_t = championship[0];
        for (int i = 1; i < championship.length; i++) {
            if (championship[i].getGolFatti() > max_t.getGolFatti()) {
                max_t = championship[i];
            }
        }
        return max_t;
    }

    /**
     * Questo metodo ritorna la squadra con la peggior difesa
     * del campionato.
     * @return
     */
    public Team peggiorDifesa() {
        if (championship.length == 0) {
            System.out.println("Errore! Campionato vuoto");
            return null;
        }
        Team max_t = championship[0];
        for (int i = 1; i < championship.length; i++) {
            if (championship[i].getGolSubiti() > max_t.getGolSubiti()) {
                max_t = championship[i];
            }
        }
        return max_t;
    }

    private static class TeamComparator implements Comparator<Team> {

        @Override
        public int compare(Team t1, Team t2) {
            if (t1.getPunteggio() == t2.getPunteggio()) {
                return -((t1.getGolFatti()-t1.getGolSubiti()) - (t2.getGolFatti() - t2.getGolSubiti()));
            }
            return -(t1.getGolFatti() - t2.getPunteggio());
        }
    }

}
