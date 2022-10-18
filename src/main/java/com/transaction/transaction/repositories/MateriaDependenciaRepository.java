package com.transaction.transaction.repositories;

import com.transaction.transaction.entities.MateriaDependencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaDependenciaRepository extends JpaRepository<MateriaDependencia, Long> {

}
