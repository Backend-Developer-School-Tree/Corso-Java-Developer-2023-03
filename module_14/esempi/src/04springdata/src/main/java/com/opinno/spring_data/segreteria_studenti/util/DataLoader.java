package com.opinno.spring_data.segreteria_studenti.util;

import com.opinno.spring_data.segreteria_studenti.Application;
import com.opinno.spring_data.segreteria_studenti.model.Corso;
import com.opinno.spring_data.segreteria_studenti.model.Esame;
import com.opinno.spring_data.segreteria_studenti.model.Libretto;
import com.opinno.spring_data.segreteria_studenti.model.Studente;
import com.opinno.spring_data.segreteria_studenti.repository.CorsoRepository;
import com.opinno.spring_data.segreteria_studenti.repository.EsameRepository;
import com.opinno.spring_data.segreteria_studenti.repository.LibrettoRepository;
import com.opinno.spring_data.segreteria_studenti.repository.StudenteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    CorsoRepository corsoRepository;

    @Autowired
    EsameRepository esameRepository;

    @Override
    public void run(String... args) throws Exception {

        // Builder è LOMBOK!!
        Libretto l1 = Libretto.builder().codiceLibretto("L001").build();
        librettoRepository.save(l1);

        // Errore perché chiave esterna viene violata, va cancellato (o modificato)
        // prima studente
        // librettoRepository.delete(l1);

        Corso c1 = Corso.builder().titolo("Fondamenti di informatica I").build();
        Corso c2 = Corso.builder().titolo("Analisi matematica I").build();
        corsoRepository.save(c1);
        corsoRepository.save(c2);

        List<Corso> corsi = new ArrayList<>();
        corsi.add(c1);
        corsi.add(c2);

        Esame e1 = Esame.builder().dataEsame(LocalDate.now()).cfu(12).build();
        Esame e2 = Esame.builder().dataEsame(LocalDate.of(2023, 11, 12)).cfu(6).build();
        esameRepository.save(e1);
        esameRepository.save(e2);

        List<Esame> esami = new ArrayList<>();
        esami.add(e1);
        esami.add(e2);

        Studente s1 = Studente.builder()
                .matricola("M001")
                .libretto(l1)
                .corso(corsi)
                .esame(esami).build();

        studenteRepository.save(s1);

        logger.info(s1.toString());

        logger.info("***** RETRIEVE ALL *****");
        List<Studente> studentiAll = studenteRepository.findAll(); 
        for(Studente s : studentiAll)
            logger.info(s.toString());

    }
}
