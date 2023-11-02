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

            /* Risposta con tutti gli utenti*/
            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(usersResult));

            return new Gson().toJson(response);
        });

        // TODO: Implementare il GetByID
        // /:id --> pathVariabile
        get("/user/:id", (req, res) -> {
            String paramID = req.params("userID"); //Prendo parametro dopo il ?

            return new Gson().toJson(new HttpResponse("200"));
        });

        post("/user", (req, res) -> {

            User userFromReq = new Gson().fromJson(req.body(), User.class);

            // TODO: Creare metodo in UserService per inserire Utente

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(userFromReq));

            return new Gson().toJson(response);
        });

        // In questo progetto l'ID dello user da aggiornare è compreso già nell'oggetto
        put("/user", (req, res) -> {

            // Devo riconvertire user che viene da richiesta REST
            User userFromReq = new Gson().fromJson(req.body(), User.class);

            // TODO: Creare metodo in UserService per aggiornare Utente

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(userFromReq));

            return new Gson().toJson(response);
        });

        delete("/user", (req, res) -> {
            String paramID = req.queryParams("userID"); //Prendo parametro dopo il ?
            // TODO: Implementare in UserService metodo per fare la delete

            return new Gson().toJson(new HttpResponse("200"));
        });
    }
}