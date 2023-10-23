package esempi.singleton;

public class Main {
    Database db = Database.getInstance();
    Database db2 = Database.getInstance();
    // db == db2
}
