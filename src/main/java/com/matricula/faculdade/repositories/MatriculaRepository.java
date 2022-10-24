package com.matricula.faculdade.repositories;

import com.matricula.faculdade.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    Matricula findByAlunoIdAndMateriaId(@Param("aluno") Long aluno, @Param("materia") Long materia);
}
