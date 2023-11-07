package com.opinno.spring_data.segreteria_studenti.util;

import com.opinno.spring_data.segreteria_studenti.Application;
import com.opinno.spring_data.segreteria_studenti.model.Libretto;
import com.opinno.spring_data.segreteria_studenti.model.Studente;
import com.opinno.spring_data.segreteria_studenti.repository.LibrettoRepository;
import com.opinno.spring_data.segreteria_studenti.repository.StudenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    static Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    LibrettoRepository librettoRepository;

    @Autowired
    StudenteRepository studenteRepository;

    @Override
    public void run(String... args) throws Exception {

        //Builder è LOMBOK!!
        Libretto l1 = Libretto.builder().codiceLibretto("L001").build();
        librettoRepository.save(l1);

        Studente s1 = Studente.builder().matricola("M001").libretto(l1).build();
        studenteRepository.save(s1);

        logger.info(s1.toString());

    }
}
