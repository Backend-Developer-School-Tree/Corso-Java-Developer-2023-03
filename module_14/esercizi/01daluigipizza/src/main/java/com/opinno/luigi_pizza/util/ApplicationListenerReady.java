package com.opinno.luigi_pizza.util;

import com.opinno.luigi_pizza.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class ApplicationListenerReady implements ApplicationListener<ApplicationReadyEvent> {
    static Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    MenuPrinter menuPrinter;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event){
        logger.info("[Application Ready]");

        menuPrinter.printMenu();
    }
}
