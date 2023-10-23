package esercizi.mailing_list_universitarie;

import esercizi.mailing_list_universitarie.exceptions.CorsoNonAssegnatoException;
import esercizi.mailing_list_universitarie.exceptions.NoMailToSendException;

import java.util.ArrayList;
import java.util.List;

public class Docente
{
    public enum Ruolo { ASSISTENTE, ASSOCIATO, ORDINARIO, A_CONTRATTO; }

    private String nome;
    private String cognome;
    private Ruolo ruolo;
    private List<Corso> corsiAssegnati = new ArrayList<>();

    /**
     * Invia una mail broadcast a tutti gli studenti iscritti alle mailing list dei corsi assegnati al docente.
     *
     * @param email testo dell'email da inviare
     * @throws NoMailToSendException se l'email è un oggetto null
     */
    public void inviaEmail(String email) throws NoMailToSendException, CorsoNonAssegnatoException {
        inviaEmail(corsiAssegnati, email);
    }

    /**
     * Invia una mail a tutti gli studenti iscritti alla mailing list del corso specificato.
     */
    public void inviaEmail(Corso corso, String email) throws NoMailToSendException, CorsoNonAssegnatoException {
        if (!corsiAssegnati.contains(corso))
            throw new CorsoNonAssegnatoException(corso, this);

        corso.inviaMail(email);
    }

    /**
     * Invia una mail a tutti gli studenti iscritti alle mailing list dei corsi specificati.
     */
    public void inviaEmail(List<Corso> corsi, String email) throws NoMailToSendException, CorsoNonAssegnatoException {
        for (Corso corso : corsi) inviaEmail(corso, email);
    }

    @Override
    public String toString() {
        return "Docente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", ruolo=" + ruolo +
                ", corsiAssegnati=" + corsiAssegnati +
                '}';
    }
}
