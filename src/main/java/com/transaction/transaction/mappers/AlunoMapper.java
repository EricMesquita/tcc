package com.transaction.transaction.mappers;

import com.transaction.transaction.dto.AlunoDTO;
import com.transaction.transaction.dto.AlunoEMatriculasDTO;
import com.transaction.transaction.dto.MatriculaDTO;
import com.transaction.transaction.entities.Aluno;
import com.transaction.transaction.entities.Matricula;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AlunoMapper {

	public Aluno toEntity(AlunoDTO dto) {
		return Aluno.builder()
				.documento( dto.getDocumento() )
				.nome(dto.getNome())
				.id( dto.getId() )
				.build();
	}

	public AlunoDTO toDTO(Aluno aluno) {
		return AlunoDTO.builder()
				.id( aluno.getId() )
				.documento( aluno.getDocumento() )
				.nome(aluno.getNome())
				.build();
	}

	public AlunoEMatriculasDTO toDTO2(Aluno aluno) {
		return AlunoEMatriculasDTO.builder()
				.id( aluno.getId() )
				.documento( aluno.getDocumento() )
				.nome(aluno.getNome())
				.matriculaDTO( toDTOlist(aluno.getMatricula()))
				.build();
	}

	private List<MatriculaDTO> toDTOlist(List<Matricula> matricula) {
		List<MatriculaDTO> matriculaDTOS = new ArrayList<>();
		for (Matricula matricula1 : matricula) {
			MatriculaDTO dto = MatriculaDTO.builder()
					.finalizado(matricula1.getFinalizado())
					.descricaoSemestre(matricula1.getDescricaoSemestre())
					.id(matricula1.getId())
					.alunoId(matricula1.getAluno().getId())
					.materiaId(matricula1.getMateria().getId())
					.build();
			matriculaDTOS.add(dto);
		}
		return matriculaDTOS;
	}
}
