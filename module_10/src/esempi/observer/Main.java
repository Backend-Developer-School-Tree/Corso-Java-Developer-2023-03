package esempi.observer;

public class Main {
    public static void main(String[] args) {
        ConnectionNotifier cn = new ConnectionNotifier();

        // gli observer / utenti si registrano in attesa di una notifica da parte dell'observable
        cn.addObserver(new User());
        cn.addObserver(new User());
        cn.addObserver(s -> System.out.println("update da lambda"));

        // nel momento in cui invochiamo questo metodo, attiviamo l'azione definita nel metodo update degli observer
        cn.notifyObservers();
    }
}
