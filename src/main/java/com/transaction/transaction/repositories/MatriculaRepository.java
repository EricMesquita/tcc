package com.transaction.transaction.repositories;

import com.transaction.transaction.entities.Account;
import com.transaction.transaction.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query("select a from Matricula a where a.aluno_id = :aluno and a.materia_id = :materia")
    Account findByAlunoIdAndMateriaID(@Param("aluno") Long aluno, @Param("materia") Long materia);
}
