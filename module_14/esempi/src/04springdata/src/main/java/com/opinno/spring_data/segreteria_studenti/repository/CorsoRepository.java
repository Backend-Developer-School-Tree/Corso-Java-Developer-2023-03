package com.opinno.spring_data.segreteria_studenti.repository;

import com.opinno.spring_data.segreteria_studenti.model.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository  extends JpaRepository<Corso, Long>{
    
}
