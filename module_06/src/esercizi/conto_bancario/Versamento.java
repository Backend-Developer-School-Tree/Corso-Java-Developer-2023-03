package esercizi.conto_bancario;

public class Versamento extends Operazione {

    private double denaroDaVersare;
    private ContoBancario contoBancario;

    public Versamento(double denaroDaVersare, ContoBancario contoBancario) {
        this.denaroDaVersare = denaroDaVersare;
        this.contoBancario = contoBancario;
    }

    @Override
    void esegui() {
        contoBancario.updateSaldo(denaroDaVersare);
    }
}
