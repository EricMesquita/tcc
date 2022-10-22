package com.transaction.transaction.services;

import com.transaction.transaction.dto.MateriaDTO;
import com.transaction.transaction.entities.Materia;
import com.transaction.transaction.entities.MateriaDependencia;
import com.transaction.transaction.exceptions.AlunoException;
import com.transaction.transaction.exceptions.MateriaException;
import com.transaction.transaction.mappers.MateriaMapper;
import com.transaction.transaction.repositories.MateriaDependenciaRepository;
import com.transaction.transaction.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class MateriaService {

	private static final String DOCUMENT_EXCEPTION_MESSAGE = "Já existe uma materia cadastrada!";
	private static final String MATERIA_DEPENDENCIA_NOT_FOUND = "A materia não foi encontrada";

	@Autowired
	private MateriaRepository repository;

	@Autowired
	private MateriaDependenciaRepository materiaDependenciaRepository;

	@Autowired
	private MateriaMapper mapper;

	public MateriaDTO create(MateriaDTO materiaDTO) {
		if (verifyIfExistsAlreadyMateria( materiaDTO ))
			throw new MateriaException( DOCUMENT_EXCEPTION_MESSAGE );
		Materia materia = repository.save( mapper.toEntity( materiaDTO ) );
		saveMateriaDependencia(materiaDTO, materia);
		return mapper.toDTO( materia );
	}

	private void saveMateriaDependencia(MateriaDTO materiaDTO, Materia materia) {
		if (verifyIfExistsAlreadyMateriaDependencia( materiaDTO ))
			throw new MateriaException( MATERIA_DEPENDENCIA_NOT_FOUND );
		if (materiaDTO.getMateriaDependencia() != null) {
			MateriaDependencia materiaDependencia = MateriaDependencia.builder()
					.materiaId(materia.getId())
					.materiaDependenciaID(materiaDTO.getMateriaDependencia())
					.build();
			materiaDependenciaRepository.save(materiaDependencia);
		}
	}

	private boolean verifyIfExistsAlreadyMateriaDependencia(MateriaDTO materiaDTO) {
		return ofNullable( materiaDependenciaRepository.findById(materiaDTO.getMateriaDependencia()) )
				.isPresent();
	}

	private boolean verifyIfExistsAlreadyMateria(MateriaDTO materiaDTO) {
		return ofNullable( repository.findByNome( materiaDTO.getNome() ) )
				.isPresent();
	}

	public boolean verifyIfExistsMateria(Long materiaId) {
		return  repository.findById( materiaId )
				.isPresent();
	}
}
