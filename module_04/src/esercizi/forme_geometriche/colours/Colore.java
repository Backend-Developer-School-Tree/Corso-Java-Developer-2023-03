package esercizi.forme_geometriche.colours;

public class Colore {

    public static final Colore NERO = new Colore(0,0,0);
    public static final Colore BIANCO = new Colore(255, 255, 255);
    private int r;
    private int g;
    private int b;

    public Colore(int r, int g, int b) {
        if (r < 0 || r > 255) {
            System.out.println("Errore! Canale rosso deve essere compreso tra 0 e 255");
        }
        else {
            this.r = r;
        }
        if (g < 0 || g > 255) {
            System.out.println("Errore! Canale verde deve essere compreso tra 0 e 255");
        }
        else {
            this.g = g;
        }
        if (b < 0 || b > 255) {
            System.out.println("Errore! Canale blu deve essere compreso tra 0 e 255");
        }
        else {
            this.b = b;
        }
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        if (r < 0 || r > 255) {
            System.out.println("Errore! Canale rosso deve essere compreso tra 0 e 255");
        }
        else {
            this.r = r;
        }
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        if (g < 0 || g > 255) {
            System.out.println("Errore! Canale verde deve essere compreso tra 0 e 255");
        }
        else {
            this.g = g;
        }
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        if (b < 0 || b > 255) {
            System.out.println("Errore! Canale blu deve essere compreso tra 0 e 255");
        }
        else {
            this.b = b;
        }
    }
}
