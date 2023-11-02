package service;

import entity.User;
import org.eclipse.jetty.server.Authentication;

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

}
