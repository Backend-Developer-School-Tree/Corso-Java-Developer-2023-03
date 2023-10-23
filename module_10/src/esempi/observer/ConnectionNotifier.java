package esempi.observer;

import java.util.ArrayList;
import java.util.List;

public class ConnectionNotifier implements Observable {
    List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update("connessione andata a buon fine!"));
    }
}
