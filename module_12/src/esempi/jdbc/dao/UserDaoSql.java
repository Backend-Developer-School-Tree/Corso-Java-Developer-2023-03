package esempi.jdbc.dao;

import esempi.jdbc.connection_handler.ConnectionHandler;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoSql implements UserDao {
    @Override
    public boolean insert(User entity) throws IOException, SQLException {
        String sql = "INSERT INTO utente (nome, cognome) VALUES (?, ?);";

        try (ConnectionHandler ch = new ConnectionHandler();
             PreparedStatement ps = ch.getPreparedStatement(sql)) {
            ps.setString(1, entity.name());
            ps.setString(2, entity.surname());
            int affectedRows = ps.executeUpdate();

            return affectedRows > 0;
        }

        /*
        // chiusura automatica tramite try-with-resources
        ch.close();
        ps.close();

        return affectedRows > 0;
         */
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
