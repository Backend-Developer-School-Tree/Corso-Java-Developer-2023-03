package esempi.simple_dao;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        UserDao userDao = new UserDaoCollection();
        User u3 = new User("myemail3@mail.com", "Roberto");
        userDao.insertOrUpdate(u3);

        for (User u : userDao.getAllUsers()) {
            System.out.println(u);
        }

        System.out.println(" ***** AGGIORNAMENTO *****");

        u3.setName("Chiara");
        userDao.insertOrUpdate(u3);
        for (User u : userDao.getAllUsers()) {
            System.out.println(u);
        }

        System.out.println(" ***** DELETE *****");
        userDao.delete(u3);
        for (User u : userDao.getAllUsers()) {
            System.out.println(u);
        }

        System.out.println(" ***** GET BY EMAIL *****");
        System.out.println(userDao.getByEmail("myemail2@mail.com"));

    }
}
