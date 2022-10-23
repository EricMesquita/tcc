package com.transaction.transaction.services;

import com.transaction.transaction.dto.AlunoDTO;
import com.transaction.transaction.dto.AlunoEMatriculasDTO;
import com.transaction.transaction.dto.MatriculaDTO;
import com.transaction.transaction.entities.Aluno;
import com.transaction.transaction.entities.Matricula;
import com.transaction.transaction.exceptions.AccountException;
import com.transaction.transaction.exceptions.AlunoException;
import com.transaction.transaction.exceptions.MatriculaException;
import com.transaction.transaction.mappers.AlunoMapper;
import com.transaction.transaction.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class AlunoService {

	private static final String DOCUMENT_EXCEPTION_MESSAGE = "Já existe um aluno cadastrado com o documento!";
	private static final String ALUNO_NOT_FOUND = "O aluno não foi encontrada";

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private MatriculaService matriculaService;

	@Autowired
	private AlunoMapper mapper;

	public AlunoDTO create(AlunoDTO alunoDTO) {
		if (verifyIfExistsAlreadyAluno( alunoDTO ))
			throw new AlunoException( DOCUMENT_EXCEPTION_MESSAGE );
		Aluno aluno = repository.save( mapper.toEntity( alunoDTO ) );
		return mapper.toDTO( aluno );
	}

	public boolean verifyIfExistsAluno(Long alunoId) {
		return repository.findById(alunoId).isPresent();
	}
	private boolean verifyIfExistsAlreadyAluno(AlunoDTO alunoDTO) {
		return ofNullable( repository.findByDocument( alunoDTO.getDocumento() ) )
				.isPresent();
	}

	public AlunoDTO find(Long alunoId) {
		return ofNullable( alunoId )
				.map( this::findById )
				.map( mapper::toDTO )
				.orElseThrow( () -> new AccountException( ALUNO_NOT_FOUND ) );
	}

	public AlunoDTO findAndMatriculas(Long alunoId) {
		return ofNullable( alunoId )
				.map( this::findById )
				.map( mapper::toDTO )
				.orElseThrow( () -> new AccountException( ALUNO_NOT_FOUND ) );
	}

	public AlunoEMatriculasDTO findMatriculas(Long alunoId) {
		return ofNullable( alunoId )
				.map( this::findById )
				.map( mapper::toDTO2 )
				.orElseThrow( () -> new AccountException( ALUNO_NOT_FOUND ) );
	}

	private Aluno findById(Long accountId) {
		return repository
				.findById( accountId )
				.orElse( null );
	}
}
