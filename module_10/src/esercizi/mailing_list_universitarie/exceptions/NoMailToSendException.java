package esercizi.mailing_list_universitarie.exceptions;

public class NoMailToSendException extends Throwable
{
    public NoMailToSendException() { super("Nessuna email da inviare. Chiamare il metodo setMailToSend prima!"); }
}
