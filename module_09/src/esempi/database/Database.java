package esempi.database;

import java.util.Collection;
import java.util.List;

public abstract class Database {

    abstract void inserisciUtente(Utente u);

    abstract Collection<Utente> getUtenti();

    abstract Utente getUtente(int id);
}
