package com.opinno.luigi_pizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    private String nome;
    private double prezzo;
    private int calorie;
}
