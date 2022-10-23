package com.transaction.transaction.repositories;

import com.transaction.transaction.entities.Account;
import com.transaction.transaction.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query("select a from Aluno a where a.documento = :documentNumber")
	Aluno findByDocument(@Param("documentNumber") String documentNumber);

}
