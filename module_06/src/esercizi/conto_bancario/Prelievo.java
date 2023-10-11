package esercizi.conto_bancario;

public class Prelievo extends Operazione {

    private double denaroDaPrelevare;

    public Prelievo(double denaroDaPrelevare) {
        this.denaroDaPrelevare = denaroDaPrelevare;
    }

    public Prelievo(double denaroDaPrelevare, ContoBancario contoBancario) {
        this.denaroDaPrelevare = denaroDaPrelevare;
        this.setContoBancario(contoBancario);
    }

    @Override
    void esegui() {
        if (getContoBancario() == null) return;
        
        if (denaroDaPrelevare > getContoBancario().getSaldo()) return;

        getContoBancario().updateSaldo(-denaroDaPrelevare);
    }
}
