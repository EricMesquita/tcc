package com.transaction.transaction.mappers;


import com.transaction.transaction.dto.MatriculaDTO;
import com.transaction.transaction.entities.Aluno;
import com.transaction.transaction.entities.Materia;
import com.transaction.transaction.entities.Matricula;
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
