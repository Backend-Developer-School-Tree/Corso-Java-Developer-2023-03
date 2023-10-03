package esercizi.forme_geometriche.forme;

import esercizi.forme_geometriche.colours.Colore;

public class Quadrato {

    private int lato;
    private Colore colore;

    public Quadrato(int lato) {
        this.lato = lato;
        this.colore = Colore.NERO;
    }

    /**
     * ritorna il perimetro del quadrato
     * @return il perimetro
     */
    public int perimetro() {
        return lato*4;
    }

    /**
     * questo metodo stampa a video il quadrato
     */
    public void stampaQuadrato() {
        String stampa = "";
        for (int i = 0; i < lato; i++) {
            for (int j = 0; j < lato; j++) {
                stampa += "* ";
            }
            stampa += "\n";
        }
        System.out.println(stampa);
    }

    public Colore getColore() {
        return colore;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
    }
}
