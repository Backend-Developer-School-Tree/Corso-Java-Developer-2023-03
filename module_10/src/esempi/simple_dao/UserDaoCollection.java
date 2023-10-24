package esempi.simple_dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoCollection implements UserDao {

    // Nel caso abbiamo un ID, da usare come chiave
    private Map<String, User> usersDatabase = new HashMap<>();

    public UserDaoCollection() {
        User u1 = new User("myemail1@mail.com", "Davide");
        User u2 = new User("myemail2@mail.com", "Anna");

        usersDatabase.put("myemail1@mail.com", u1);
        usersDatabase.put("myemail2@mail.com", u2);

    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(usersDatabase.values());
    }

    // Decido di far tornare lo user dopo l'inserimento perché potrei avere un ID
    // generato nel database
    @Override
    public User insertOrUpdate(User u) {
        usersDatabase.put(u.getEmail(), u);
        return u;
    }

    /*
     * @Override
     * public User update(User u) {
     * usersDatabase.put(u.getEmail(), u);
     * return u;
     * }
     */

    @Override
    public User getByEmail(String email) {
        return usersDatabase.get(email);
    }

    @Override
    public void delete(User u) {
        usersDatabase.remove(u.getEmail());
    }

}
