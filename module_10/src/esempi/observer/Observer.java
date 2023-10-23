package esempi.observer;

// dipende dal caso d'uso se può essere utile avere la possibilità di definire gli Observer come lambda
@FunctionalInterface
public interface Observer {
    public void update(String message);
}
