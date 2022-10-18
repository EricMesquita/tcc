package com.transaction.transaction.services;

import com.transaction.transaction.dto.MateriaDTO;
import com.transaction.transaction.entities.Materia;
import com.transaction.transaction.exceptions.AlunoException;
import com.transaction.transaction.mappers.MateriaMapper;
import com.transaction.transaction.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class MateriaService {

	private static final String DOCUMENT_EXCEPTION_MESSAGE = "Já existe uma materia cadastrada!";
	private static final String ALUNO_NOT_FOUND = "A materia não foi encontrada";

	@Autowired
	private MateriaRepository repository;

	@Autowired
	private MateriaMapper mapper;

	public MateriaDTO create(MateriaDTO materiaDTO) {
		if (verifyIfExistsAlreadyMateria( materiaDTO ))
			throw new AlunoException( DOCUMENT_EXCEPTION_MESSAGE );
		Materia materia = repository.save( mapper.toEntity( materiaDTO ) );
		return mapper.toDTO( materia );
	}

	private boolean verifyIfExistsAlreadyMateria(MateriaDTO materiaDTO) {
		return ofNullable( repository.findByNome( materiaDTO.getNome() ) )
				.isPresent();
	}

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
