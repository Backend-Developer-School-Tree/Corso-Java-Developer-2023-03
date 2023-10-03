package esercizi.lampadina;

public class Interruttore {

    private Lampadina lampadina;

    public Interruttore(Lampadina lampadina) {
        this.lampadina = lampadina;
    }

    public void click() {
        lampadina.click();
    }

}
