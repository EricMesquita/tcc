package com.transaction.transaction.services;

import com.transaction.transaction.dto.MatriculaDTO;
import com.transaction.transaction.entities.Matricula;
import com.transaction.transaction.mappers.MatriculaMapper;
import com.transaction.transaction.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

	private static final String DOCUMENT_EXCEPTION_MESSAGE = "Já existe uma matricula cadastrado para este aluno!";
	private static final String ALUNO_NOT_FOUND = "O aluno não foi encontrada";

	@Autowired
	private MatriculaRepository repository;

	@Autowired
	private MatriculaMapper mapper;

	public MatriculaDTO create(MatriculaDTO matriculaDTO) {
//		if (verifyIfExistsAlreadyMatricula( matriculaDTO ))
//			throw new AlunoException( DOCUMENT_EXCEPTION_MESSAGE );
		Matricula matricula = repository.save( mapper.toEntity( matriculaDTO ) );
		return mapper.toDTO( matricula );
	}

//	private boolean verifyIfExistsAlreadyMatricula(MatriculaDTO matriculaDTO) {
//		return ofNullable( repository.findByDocument( matriculaDTO.getDocumento() ) )
//				.isPresent();
//	}
//
//	public AlunoDTO find(Long alunoId) {
//		return ofNullable( alunoId )
//				.map( this::findById )
//				.map( mapper::toDTO )
//				.orElseThrow( () -> new AccountException( ALUNO_NOT_FOUND ) );
//	}
//
//	private Aluno findById(Long accountId) {
//		return repository
//				.findById( accountId )
//				.orElse( null );
//	}
}
