package esempi.singleton;

public class Database
{
    private static Database internalInstance;

    private Database() {
        // operazioni molto pesanti in memoria da fare una sola volta
    }

    public static Database getInstance() {
        // l'effettiva creazione dell'istanza avverrà una sola volta alla prima chiamata di getInstance
        if (internalInstance == null)
            internalInstance = new Database();

        // tutte le chiamate successive ritorneranno direttamente la medesima istanza creata precedentemente
        return internalInstance;
    }
}
