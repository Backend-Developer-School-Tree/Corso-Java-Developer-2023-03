package com.opinno.luigi_pizza.util;

import com.opinno.luigi_pizza.Application;
import com.opinno.luigi_pizza.model.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MenuPrinter {

    static Logger logger = LoggerFactory.getLogger(MenuPrinter.class);

    private ApplicationContext ctx;

    @Autowired
    public MenuPrinter(ApplicationContext ctx){
        this.ctx = ctx;
    }

    public void printMenu(){
        logger.info("**** STAMPA MENU ****");

        // Elenco di tutti i bean di tipo Pizza presenti nella mia configuration (o meglio nel Container)
        String[] pizzaBeansNames = ctx.getBeanNamesForType(Pizza.class);
        logger.info("MENU:");
        for(String beanName : pizzaBeansNames){
            Pizza p = (Pizza) ctx.getBean(beanName);

            logger.info(p.toString());
            logger.info("");
        }

    }
}
