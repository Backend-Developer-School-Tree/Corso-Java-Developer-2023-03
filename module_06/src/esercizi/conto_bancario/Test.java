package esercizi.conto_bancario;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        ContoBancario cb = new ContoBancario("IT1124H1823415");

        Versamento vers = new Versamento(1000, cb);

        Prelievo prel = new Prelievo(500, cb);

        cb.eseguiOperazioni(List.of(vers, prel));

        cb.versamento(50);

        System.out.println(cb.getOperazioniSvolte());

    }

}
