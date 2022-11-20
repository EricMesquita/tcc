package com.matricula.faculdade.services;

import com.matricula.faculdade.mappers.MatriculaMapper;
import com.matricula.faculdade.dto.MatriculaDTO;
import com.matricula.faculdade.entities.Matricula;
import com.matricula.faculdade.exceptions.AlunoException;
import com.matricula.faculdade.exceptions.MatriculaException;
import com.matricula.faculdade.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		/*if (!alunoService.verifyIfExistsAluno( matriculaDTO.getAlunoId() ))
			throw new AlunoException( ALUNO_NOT_FOUND );
		if (!materiaService.verifyIfExistsMateria(matriculaDTO.getMateriaId()))
			throw new AlunoException( MATERIA_NOT_FOUND );
		if (verifyIfExistsMatricula(matriculaDTO))
			throw new MatriculaException(MATRICULA_EXCEPTION_MESSAGE);*/
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
