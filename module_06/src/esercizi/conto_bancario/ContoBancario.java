package esercizi.conto_bancario;

import java.util.ArrayList;
import java.util.List;

public class ContoBancario {

    private double saldo = 0.0;
    private final String iban;
    private List<Operazione> operazioniRecenti = new ArrayList<>();

    public ContoBancario(String iban) {
        this.iban = iban;
    }

    protected void updateSaldo(double differenzaSaldo) { this.saldo += differenzaSaldo; }

    public void eseguiOperazione(Operazione operazione) {
        operazioniRecenti.add(operazione);
        operazione.esegui();
    }

    // ...

    public void versaDenaro(double denaroDaVersare) {
        eseguiOperazione(new Versamento(denaroDaVersare, this));
    }
}
