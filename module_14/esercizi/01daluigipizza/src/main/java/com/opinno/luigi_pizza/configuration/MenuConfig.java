package com.opinno.luigi_pizza.configuration;

import com.opinno.luigi_pizza.model.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuConfig {

    @Bean
    public Pizza Margherita() {
        return new Pizza("Margherita", 9.99, 800);
    }

    @Bean
    public Pizza Peperoni() {
        return new Pizza("Peperoni", 12, 1200);
    }
}
