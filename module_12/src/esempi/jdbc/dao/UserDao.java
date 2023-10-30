package esempi.jdbc.dao;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    // aggiunge metodi specifici solo per User

    // es. Optional<User> getByEmail(String email);
}
