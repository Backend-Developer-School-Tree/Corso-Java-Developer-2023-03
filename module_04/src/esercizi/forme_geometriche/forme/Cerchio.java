package esercizi.forme_geometriche.forme;

import esercizi.forme_geometriche.colours.Colore;

public class Cerchio {

    private double raggio;
    private Colore colore;

    public Cerchio(double raggio) {
        this.raggio = raggio;
        this.colore = Colore.NERO;
    }

    /**
     * questo metodo calcola la circonferenza del cerchio
     * @return la circonferenza
     */
    public double circonferenza() {
        return 2*Math.PI*raggio;
    }

    /**
     * questo metodo calcola l'area del cerchio
     * @return l'area del cerchio
     */
    public double area() {
        return Math.PI*Math.pow(raggio, 2);
    }

    public Colore getColore() {
        return colore;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
    }
}
