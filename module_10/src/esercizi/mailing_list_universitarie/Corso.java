package esercizi.mailing_list_universitarie;

import esercizi.mailing_list_universitarie.exceptions.NoMailToSendException;

import java.util.ArrayList;
import java.util.List;

// @AllArgsConstructor
public class Corso
{
    // codiceEdificio, ...
    private Docente docente;
    private String nomeAula;
    private String nomeCorso;
    private MailingList mailingList;
    private List<Studente> studentiIscritti = new ArrayList<>();

    // public Corso(...) {}

    public void iscriviStudente(Studente studente) {
        studentiIscritti.add(studente);
    }

    public void inviaMail(String mail) throws NoMailToSendException {
        mailingList.setMailToSend(mail);
        mailingList.notifyObservers();
    }

    @Override
    public String toString() {
        return "Corso{" +
                "docente=" + docente +
                ", nomeCorso='" + nomeCorso + '\'' +
                ", nomeAula='" + nomeAula + '\'' +
                '}';
    }
}
