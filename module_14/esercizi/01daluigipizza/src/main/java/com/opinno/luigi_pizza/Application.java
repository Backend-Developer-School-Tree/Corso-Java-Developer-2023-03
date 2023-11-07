package com.opinno.luigi_pizza;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		logger.info("SYSTEM STARTUP: BEGIN");

		SpringApplication.run(Application.class, args);

		logger.info("SYSTEM STARTUP: END");
	}

}
