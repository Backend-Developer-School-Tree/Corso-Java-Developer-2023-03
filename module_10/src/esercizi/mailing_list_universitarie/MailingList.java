package esercizi.mailing_list_universitarie;

import esercizi.mailing_list_universitarie.exceptions.NoMailToSendException;

import java.util.ArrayList;
import java.util.List;

public class MailingList implements Observable
{
    private String mailToSend;
    private List<Observer> observers = new ArrayList<>();

    public void setMailToSend(String mail) { this.mailToSend = mail; }

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() throws NoMailToSendException
    {
        // l'alternativa a generare un errore sarebbe "non fare nulla"
        // ma non daremo nessuna informazione al riguardo al metodo chiamante (quanto è safe?)
        if (mailToSend == null) throw new NoMailToSendException();

        observers.forEach(observer -> observer.update(mailToSend));
        mailToSend = null;
    }
}
