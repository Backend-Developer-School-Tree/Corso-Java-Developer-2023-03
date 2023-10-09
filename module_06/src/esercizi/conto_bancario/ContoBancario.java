package esercizi.conto_bancario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContoBancario {

    private double saldo = 0.0;
    private final String iban;
    private ArrayList<Operazione> operazioniSvolte = new ArrayList<>();

    public ContoBancario(String iban) { this.iban = iban; }

    protected void updateSaldo(double differenzaSaldo) { saldo += differenzaSaldo; }

    public void eseguiOperazione(Operazione operazione) {
        operazione.setContoBancario(this);
        operazione.esegui();
        operazioniSvolte.add(operazione);
    }

    public void eseguiOperazioni(List<Operazione> operazioni) {
        for (Operazione operazione : operazioni) {
            eseguiOperazione(operazione);
        }
    }

    public void versamento(double denaroDaVersare) {
        Versamento versamento = new Versamento(denaroDaVersare, this);
        eseguiOperazione(versamento);
        // quando passiamo un oggetto di tipo Versamento al metodo eseguiOperazione
        // viene implicitamente castato a tipo Operazione (quindi usiamo il polimorfismo!)
    }

    // TODO SvuotaConto: preleva tutto il denaro da un dato conto

    // TODO Situazione: stampa l’attuale saldo del conto

    // TODO Bonifico: preleva del denaro da un conto e lo versa su un altro

    public void prelievo(double denaroDaPrelevare) {
        // controllo delegato all classe Prelievo
        // if (denaroDaPrelevare > saldo) return;

        Prelievo prelievo = new Prelievo(denaroDaPrelevare, this);
        eseguiOperazione(prelievo);
    }

    public List<Operazione> getOperazioniSvolte() {
        operazioniSvolte.sort(Comparator.comparing(Operazione::getCreazione).reversed());
        return operazioniSvolte;
    }

    public double getSaldo() { return saldo; }

}
