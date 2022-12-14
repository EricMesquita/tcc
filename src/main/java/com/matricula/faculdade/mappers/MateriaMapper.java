package com.matricula.faculdade.mappers;

import com.matricula.faculdade.dto.MateriaDTO;
import com.matricula.faculdade.entities.Materia;
import org.springframework.stereotype.Component;

@Component
public class MateriaMapper {

	public Materia toEntity(MateriaDTO dto) {
		return Materia.builder()
				.nome( dto.getNome() )
				.id( dto.getId() )
				.capacidade( dto.getCapacidade() )
				.build();
	}

	public MateriaDTO toDTO(Materia materia) {
		return MateriaDTO.builder()
				.id( materia.getId() )
				.capacidade( materia.getCapacidade() )
				.nome(materia.getNome())
				.build();
	}
}
