package controller;

import com.google.gson.Gson;
import entity.User;
import service.UserService;
import util.HttpResponse;

import java.util.List;

import static spark.Spark.*;

/* Punto di ingresso verso il mio applicativo dall'esterno*/
public class UserController {
    UserService userService = new UserService();

    public void startServices() {

        // heartbeat
        get("/", (req, res) -> "System is working");

        get("/users", (req, res) -> {
            List<User> usersResult = userService.findAll();

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(usersResult));

            return new Gson().toJson(response);
        });

        get("/user/:id", (req, res) -> {
            String paramID = req.params("id"); // Corretto il nome del parametro

            User user = userService.findUserById(paramID);

            if (user != null) {
                return new Gson().toJson(new HttpResponse("200", "OK", new Gson().toJsonTree(user)));
            } else {
                return new Gson().toJson(new HttpResponse("404", "Utente non trovato"));
            }
        });

        post("/user", (req, res) -> {
            User userFromReq = new Gson().fromJson(req.body(), User.class);

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(userService.addUser(userFromReq)));

            return new Gson().toJson(response);
        });

        put("/user", (req, res) -> {
            User userFromReq = new Gson().fromJson(req.body(), User.class);
            userService.updateUser(userFromReq);

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(userFromReq));

            return new Gson().toJson(response);
        });

        delete("/user", (req, res) -> {
            String paramID = req.queryParams("userID");
            userService.deleteUser(paramID);

            return new Gson().toJson(new HttpResponse("200", "User deleted"));
        });
    }
}
