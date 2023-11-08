package com.opinno.springmvc.service;

import com.opinno.springmvc.model.Studente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudenteService {

    // StudenteRepository

    public List<Studente> findAllStudents() {
        List<Studente> studenti = new ArrayList<>();
        Studente s1 = Studente.builder().id(1L).name("Studente 1").build();
        Studente s2 = Studente.builder().id(2L).name("Studente 21").build();

        studenti.add(s1);
        studenti.add(s2);

        return studenti;

    }
}