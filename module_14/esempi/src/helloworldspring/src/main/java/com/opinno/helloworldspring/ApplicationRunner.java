package helloworldspring.src.main.java.com.opinno.helloworldspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    static Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Value("${myapplication.param}")
    private String path2Database;

    @Override
    public void run(String... args) throws Exception {
        logger.info("***** Runner startup: BEGIN *****");

        // Caricamento dati in persistenza
        // Logging specifico
        // Invocazione di un servizio REST
        // Controllo di parametri
        // Funzionalità di persistenza
        // ...

        logger.info("path2Database: " + path2Database);

        logger.info("**** Runner startup: END **** ");
    }
}
