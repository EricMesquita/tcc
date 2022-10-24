package com.matricula.faculdade.repositories;

import com.matricula.faculdade.entities.MateriaDependencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaDependenciaRepository extends JpaRepository<MateriaDependencia, Long> {

}
