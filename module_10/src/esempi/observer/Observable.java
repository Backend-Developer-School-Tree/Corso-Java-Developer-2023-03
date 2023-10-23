package esempi.observer;

// non è strettamente necessario farla generica, dipende dal caso d'uso
public interface Observable {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
