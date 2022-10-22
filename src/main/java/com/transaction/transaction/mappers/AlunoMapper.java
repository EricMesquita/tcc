package com.transaction.transaction.mappers;

import com.transaction.transaction.dto.AlunoDTO;
import com.transaction.transaction.entities.Aluno;
import org.springframework.stereotype.Component;

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
}
