package com.opinno.spring_data.segreteria_studenti.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List; 

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Libretto libretto;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Corso> corso; 

    @OneToMany(fetch = FetchType.EAGER)
    private List<Esame> esame; 

    private String matricola;
}
