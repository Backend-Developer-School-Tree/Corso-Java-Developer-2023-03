package esercizi.mailing_list_universitarie.exceptions;

import esercizi.mailing_list_universitarie.Corso;
import esercizi.mailing_list_universitarie.Docente;

public class CorsoNonAssegnatoException extends Throwable {
    public CorsoNonAssegnatoException(Corso corso, Docente docente) {
        super("Il corso " + corso + " non è assegnato al docente " + docente);
    }
}
