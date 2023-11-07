package com.opinno.spring_data.segreteria_studenti.repository;

import com.opinno.spring_data.segreteria_studenti.model.Libretto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrettoRepository extends JpaRepository<Libretto, Long> {

}
