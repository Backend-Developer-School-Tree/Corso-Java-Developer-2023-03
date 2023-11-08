package com.opinno.spring_data.segreteria_studenti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.opinno.spring_data.segreteria_studenti.model.Esame;

public interface EsameRepository extends JpaRepository<Esame, Long> {

}
