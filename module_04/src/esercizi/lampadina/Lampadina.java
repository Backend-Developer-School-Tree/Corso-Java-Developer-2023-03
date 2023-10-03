package esercizi.lampadina;

public class Lampadina {

    private int status;
    private int count;
    private int maxClick;

    public Lampadina(int maxClick) {
        this.status = 0;
        this.count = 0;
        if (maxClick <= 0) {
            System.out.println("Numero di max click errato!");
            this.maxClick = 0;
        }
        else {
            this.maxClick = maxClick;
        }
    }

    /**
     * getter per lo status
     * @return lo status della lampadina
     */
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void click() {
        if (Impianto.isElectricity()) {
            if (count == maxClick) {
                System.out.println("LAMPADINA ROTTA!");
            }
            else if (count == maxClick - 1) {
                count++;
                status = -1;
            }
            else {
                count++;
                status = (status == 0 ? 1 : 0);
            }
        }
        else System.out.println("NESSUNA CORRENTE!");
    }

    public String printStatus() {
        switch (status) {
            case 0 : return "SPENTA";
            case 1 : return "ACCESA";
            case -1 : return "ROTTA";
            default: return "ERROR";
        }
    }


}
