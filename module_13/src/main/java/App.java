import controller.UserController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserController userController = new UserController();
        userController.startServices();
    }
}
