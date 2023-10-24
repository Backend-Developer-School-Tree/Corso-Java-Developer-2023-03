package esempi.simple_dao;

import java.util.List;

public interface UserDao {

    // Potrei chiamarlo anche saveUser
    User insertOrUpdate(User u);

    // In questo particolare esempio update è uguale a insert, non sto gestendo assenza o presenza dell'ID
    //User update(User u);

    User getByEmail(String email);

    // Volendo potrei passare anche solo direttamente la email che è la chiave primaria
    void delete(User u);

    List<User> getAllUsers();

}
