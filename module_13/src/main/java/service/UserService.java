package service;

import entity.User;

import java.util.ArrayList;
import java.util.List;

// TODO: Implementare DAO e i DAOImpl
// TODO: UserService come Singleton
public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User("User 1", "1"));
        users.add(new User("User 2", "2"));
        users.add(new User("User 3", "3"));

    }

    public List<User> findAll() {

        return users;
    }

    // TODO: Implementare ID autonumerante (o randomico)
    public User addUser(User user) {
        users.add(user);

        return user;
    }

    // Se l'utente non esiste, puoi gestire l'errore o lanciare un'eccezione
    // ad esempio: throw new IllegalArgumentException("Utente non trovato");
    public void updateUser(User updatedUser) {
        for (User user : users) {
            if (user.getUserID().equals(updatedUser.getUserID())) {
                user.setUsername(updatedUser.getUsername());
                return;
            }
        }
    }

    public void deleteUser(String userId) {
        users.removeIf(user -> user.getUserID().equals(userId));
    }

    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserID().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}
