package com.matricula.faculdade.services;

import com.matricula.faculdade.dto.MateriaDTO;
import com.matricula.faculdade.exceptions.MateriaException;
import com.matricula.faculdade.mappers.MateriaMapper;
import com.matricula.faculdade.entities.Materia;
import com.matricula.faculdade.entities.MateriaDependencia;
import com.matricula.faculdade.repositories.MateriaDependenciaRepository;
import com.matricula.faculdade.repositories.MateriaRepository;
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
		//if (verifyIfExistsAlreadyMateria( materiaDTO ))
		//	throw new MateriaException( DOCUMENT_EXCEPTION_MESSAGE );
		Materia materia = repository.save( mapper.toEntity( materiaDTO ) );
		MateriaDependencia md = saveMateriaDependencia(materiaDTO, materia);
		MateriaDTO dto = mapper.toDTO( materia );
		if (md != null) {
			dto.setMateriaDependencia(md.getMateriaDependenciaId());
		}
		return dto;
	}

	private MateriaDependencia saveMateriaDependencia(MateriaDTO materiaDTO, Materia materia) {
		if (verifyIfExistsMateria( materiaDTO ))
			throw new MateriaException( MATERIA_DEPENDENCIA_NOT_FOUND );
		if (materiaDTO.getMateriaDependencia() != null) {
			MateriaDependencia materiaDependencia = MateriaDependencia.builder()
					.materiaId(materia.getId())
					.materiaDependenciaId(materiaDTO.getMateriaDependencia())
					.build();
			return materiaDependenciaRepository.save(materiaDependencia);
		}
		return null;
	}

	private boolean verifyIfExistsMateria(MateriaDTO materiaDTO) {
		if (materiaDTO.getMateriaDependencia() == null) {
			return false;
		}
		return repository.findById(materiaDTO.getMateriaDependencia()).isEmpty();
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
