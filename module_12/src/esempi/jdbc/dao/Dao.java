package esempi.jdbc.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    boolean insert(T entity) throws IOException, SQLException;
    boolean update(T entity);
    boolean delete(T entity);
    Optional<T> get(int id);
    List<T> getAll();
}
