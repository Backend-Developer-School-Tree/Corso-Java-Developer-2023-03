package com.opinno.spring_data.segreteria_studenti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Libretto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codiceLibretto;

    public Libretto(String codiceLibretto){
        this.codiceLibretto = codiceLibretto;
    }

}
