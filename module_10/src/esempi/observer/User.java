package esempi.observer;

public class User implements Observer {
    @Override
    public void update(String message) {
        if (message.contains("buon fine"))
            System.out.println("connessione stabilita");
    }
}
