package com.matricula.faculdade.mappers;


import com.matricula.faculdade.dto.MatriculaDTO;
import com.matricula.faculdade.entities.Aluno;
import com.matricula.faculdade.entities.Materia;
import com.matricula.faculdade.entities.Matricula;
import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {

	public Matricula toEntity(MatriculaDTO dto) {
		return Matricula.builder()
				.id( dto.getId() )
				.descricaoSemestre( dto.getDescricaoSemestre() )
				.finalizado( dto.getFinalizado() )
				.aluno( Aluno.builder().id(dto.getAlunoId()).build())
				.materia( Materia.builder().id(dto.getMateriaId()).build())
				.build();
	}

	public MatriculaDTO toDTO(Matricula materia) {
		return MatriculaDTO.builder()
				.id( materia.getId() )
				.descricaoSemestre( materia.getDescricaoSemestre() )
				.finalizado( materia.getFinalizado() )
				.build();
	}
}
