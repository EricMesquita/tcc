package com.matricula.faculdade.services;

import com.matricula.faculdade.dto.AlunoEMatriculasDTO;
import com.matricula.faculdade.exceptions.AlunoException;
import com.matricula.faculdade.mappers.AlunoMapper;
import com.matricula.faculdade.repositories.AlunoRepository;
import com.matricula.faculdade.dto.AlunoDTO;
import com.matricula.faculdade.entities.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
				.orElseThrow( () -> new AlunoException( ALUNO_NOT_FOUND ) );
	}

	public AlunoDTO findAndMatriculas(Long alunoId) {
		return ofNullable( alunoId )
				.map( this::findById )
				.map( mapper::toDTO )
				.orElseThrow( () -> new AlunoException( ALUNO_NOT_FOUND ) );
	}

	public AlunoEMatriculasDTO findMatriculas(Long alunoId) {
		return ofNullable( alunoId )
				.map( this::findById )
				.map( mapper::toDTO2 )
				.orElseThrow( () -> new AlunoException( ALUNO_NOT_FOUND ) );
	}

	private Aluno findById(Long accountId) {
		return repository
				.findById( accountId )
				.orElse( null );
	}
}
