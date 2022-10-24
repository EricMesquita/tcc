package com.transaction.transaction.services;

import com.transaction.transaction.dto.MatriculaDTO;
import com.transaction.transaction.entities.Matricula;
import com.transaction.transaction.exceptions.AlunoException;
import com.transaction.transaction.exceptions.MatriculaException;
import com.transaction.transaction.mappers.MatriculaMapper;
import com.transaction.transaction.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class MatriculaService {

	private static final String MATRICULA_EXCEPTION_MESSAGE = "Já existe uma matricula cadastrado para este aluno!";
	private static final String ALUNO_NOT_FOUND = "O aluno não foi encontrada";
	private static final String MATERIA_NOT_FOUND = "A materia não foi encontrada";


	@Autowired
	private MatriculaRepository repository;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private MateriaService materiaService;

	@Autowired
	private MatriculaMapper mapper;

	public MatriculaDTO create(MatriculaDTO matriculaDTO) {
		if (!alunoService.verifyIfExistsAluno( matriculaDTO.getAlunoId() ))
			throw new AlunoException( ALUNO_NOT_FOUND );
		if (!materiaService.verifyIfExistsMateria(matriculaDTO.getMateriaId()))
			throw new AlunoException( MATERIA_NOT_FOUND );
		if (verifyIfExistsMatricula(matriculaDTO))
			throw new MatriculaException(MATRICULA_EXCEPTION_MESSAGE);
		Matricula matricula = repository.save( mapper.toEntity( matriculaDTO ) );
		MatriculaDTO dto = mapper.toDTO( matricula );
		dto.setAlunoId(matriculaDTO.getAlunoId());
		dto.setMateriaId(matriculaDTO.getMateriaId());
		return dto;
	}

	private boolean verifyIfExistsMatricula(MatriculaDTO matriculaDTO) {
		return ofNullable(repository.findByAlunoIdAndMateriaId(matriculaDTO.getAlunoId(), matriculaDTO.getMateriaId())).isPresent();
	}
}
