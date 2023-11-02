package controller;

import static spark.Spark.get;

/* Punto di ingresso verso il mio applicativo dall'esterno*/
public class UserController {

    public void startServices(){

        // heartbeat
        get("/", (req, res) -> "System is working");
    }
}
