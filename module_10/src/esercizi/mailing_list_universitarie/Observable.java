package esercizi.mailing_list_universitarie;

import esercizi.mailing_list_universitarie.exceptions.NoMailToSendException;

public interface Observable {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers() throws NoMailToSendException;
}
