package esercizi.lampadina;

public class Impianto {

    private static boolean electricity;
    private Lampadina[] lampadine;

    public Impianto(boolean electricity, Lampadina[] lampadine) {
        this.electricity = electricity;
        this.lampadine = lampadine;
    }

    public static boolean isElectricity() {
        return electricity;
    }

    public void setElectricity(boolean electricity) {
        if (electricity == false) {
            for (Lampadina lampadina : lampadine) {
                if (lampadina.getStatus() == 1) {
                    lampadina.setStatus(0);
                }
            }
        }
        this.electricity = electricity;
    }
}
