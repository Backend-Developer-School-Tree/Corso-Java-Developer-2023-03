package esercizi.conto_bancario;

public class Versamento extends Operazione {

    private final ContoBancario contoBancario;
    private final double denaroDaVersare;

    public Versamento(double denaroDaVersare, ContoBancario contoBancario) {
        this.denaroDaVersare = denaroDaVersare;
        this.contoBancario = contoBancario;
    }

    @Override
    public void esegui() {
        contoBancario.updateSaldo(denaroDaVersare);
    }
}
