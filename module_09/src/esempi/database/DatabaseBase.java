package esempi.database;

import java.util.*;

public class DatabaseBase extends Database {

    private Map<Integer, Utente> utenti = new HashMap<>();

    @Override
    void inserisciUtente(Utente u) {
        utenti.put(u.id(), u);
    }

    @Override
    Collection<Utente> getUtenti() {
        return utenti.values();
    }

    @Override
    Utente getUtente(int id) {
        return utenti.get(id);
    }
}
