package helloworldspring.src.main.java.com.opinno.helloworldspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloworldspringApplication {

	static Logger logger = LoggerFactory.getLogger(HelloworldspringApplication.class);

	public static void main(String[] args) {
		logger.info("*** SYSTEM STARTUP: BEGIN ***");

		logger.error("*** ERROR STATUP ***");


		SpringApplication.run(HelloworldspringApplication.class, args);

		logger.info("*** SYSTEM STARTUP: END ***");
	}

}
