package esercizi.seriea;

public class Team implements Comparable<Team> {

    // attributi
    private static int idTot = 0;
    private int id;
    private String nome;
    private Giocatore[] rosa;
    private int punteggio;
    private int golFatti;
    private int golSubiti;

    // costruttori
    public Team(String nome) {
        this.id = idTot;
        idTot++;
        this.nome = nome;
        this.rosa = new Giocatore[0];
    }

    public Team(String nome, int punteggio, int golFatti, int golSubiti) {
        this.id = idTot;
        idTot++;
        this.nome = nome;
        this.punteggio = punteggio;
        this.golFatti = golFatti;
        this.golSubiti = golSubiti;
        this.rosa = new Giocatore[0];
    }

    public Team(String nome, Giocatore[] rosa, int punteggio, int golFatti, int golSubiti) {
        this.id = idTot;
        idTot++;
        this.nome = nome;
        this.rosa = rosa;
        this.punteggio = punteggio;
        this.golFatti = golFatti;
        this.golSubiti = golSubiti;
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Giocatore[] getRosa() {
        return rosa;
    }

    public void setRosa(Giocatore[] rosa) {
        this.rosa = rosa;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getGolFatti() {
        return golFatti;
    }

    public void setGolFatti(int golFatti) {
        this.golFatti = golFatti;
    }

    public int getGolSubiti() {
        return golSubiti;
    }

    public void setGolSubiti(int golSubiti) {
        this.golSubiti = golSubiti;
    }

    /**
     * Questo metodo aggiunge un giocatore alla rosa del team
     * @param g un Giocatore
     */
    public void addPlayer(Giocatore g) {
        Giocatore[] tmp = new Giocatore[rosa.length+1];
        for (int i = 0; i < rosa.length; i++) {
            tmp[i] = rosa[i];
        }
        tmp[rosa.length] = g;
        rosa = tmp;
        tmp = new Giocatore[0];
    }

    /**
     * Questo metodo rimuove un giocatore dalla rosa. Se il giocatore
     * non è presente stampa un messaggio di errore.
     * @param g il giocatore da rimuovere
     */
    public void removePlayer(Giocatore g) {
        Giocatore[] tmp = new Giocatore[rosa.length-1];
        int index = -1;
        for (int i = 0; i < rosa.length; i++) {
            if (rosa[i] == g) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("ERRORE! Giocatore non trovato");
        }
        else {
            for (int i = 0; i < index; i++) {
                tmp[i] = rosa[i];
            }
            for (int i = index; i < tmp.length; i++) {
                tmp[i] = rosa[i+1];
            }
            rosa = tmp;
            tmp = new Giocatore[0];
        }
    }

    /**
     * Questo metodo calcola una vittoria per il Team. Incrementa
     * di 3 il suo punteggio e incrementa i gol fatti e subiti in
     * base al risultato.
     * @param fatti gol fatti
     * @param subiti gol subiti
     */
    public void vittoria(int fatti, int subiti) {
        this.punteggio += 3;
        this.golFatti += fatti;
        this.golSubiti += subiti;
    }

    /**
     * Questo metodo calcola un pareggio per il Team. Incrementa
     * di 1 il suo punteggio e incrementa i gol fatti e subiti in
     * base al risultato.
     * @param gol
     */
    public void pareggio(int gol) {
        this.punteggio++;
        this.golFatti += gol;
        this.golSubiti += gol;
    }

    /**
     * Questo metodo calcola una vittoria per il Team. Non incrementa
     * il suo punteggio e incrementa i gol fatti e subiti in
     * base al risultato.
     * @param fatti
     * @param subiti
     */
    public void sconfitta(int fatti, int subiti) {
        this.golFatti += fatti;
        this.golSubiti += subiti;
    }

    /**
     * Ordiniamo le squadre in base al punteggio. Se hanno
     * lo stesso punteggio conta la differenza reti.
     * @param t il team da confrontare
     * @return
     */
    @Override
    public int compareTo(Team t) {
        if (this.punteggio == t.punteggio) {
            return -((this.golFatti-this.golSubiti) - (t.golFatti - t.golSubiti));
        }
        return -(this.punteggio - t.punteggio);
    }

    @Override
    public String toString() {
        return nome + " " + punteggio + " " + golFatti + " " + golSubiti;
    }

    public void printRosa() {
        String s = nome.toUpperCase() + "\n";
        for (Giocatore g : rosa) {
            s += g.toString() + "\n";
        }
        System.out.println(s);
    }
}
