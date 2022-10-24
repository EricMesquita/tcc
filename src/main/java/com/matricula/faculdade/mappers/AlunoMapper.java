package com.matricula.faculdade.mappers;

import com.matricula.faculdade.dto.AlunoEMatriculasDTO;
import com.matricula.faculdade.dto.AlunoDTO;
import com.matricula.faculdade.dto.MatriculaDTO;
import com.matricula.faculdade.entities.Aluno;
import com.matricula.faculdade.entities.Matricula;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
