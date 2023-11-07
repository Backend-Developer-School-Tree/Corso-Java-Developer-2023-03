package com.opinno.spring_data.segreteria_studenti.repository;

import com.opinno.spring_data.segreteria_studenti.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {
}
