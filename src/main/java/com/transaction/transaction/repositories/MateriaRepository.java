package com.transaction.transaction.repositories;

import com.transaction.transaction.entities.Account;
import com.transaction.transaction.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

    @Query("select a from Materia a where a.nome = :nome")
    Account findByNome(@Param("nome") String nome);
}
