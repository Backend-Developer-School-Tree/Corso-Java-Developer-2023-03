package com.opinno.spring_data.segreteria_studenti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Corso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*@ManyToMany(mappedBy = "corso")
    private List<Studente> studente; */

    private String titolo; 
}
