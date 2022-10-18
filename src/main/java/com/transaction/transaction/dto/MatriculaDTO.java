package com.transaction.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("aluno_id")
	@NotNull(message = "O id do aluno não pode ser nulo")
	@NotEmpty(message = "O id do aluno não pode ser não vazio")
	private Long alunoId;

	@JsonProperty("materia_id")
	@NotNull(message = "A id da matricula não pode ser nulo")
	@NotEmpty(message = "A id da matricula não pode ser não vazio")
	private Long materiaId;

	@JsonProperty("descricao_semestre")
	@NotNull(message = "A descrição do semestre não pode ser nulo")
	@NotEmpty(message = "A descrição do semestre não pode ser não vazio")
	private String descricaoSemestre;

	@JsonProperty("finalizado")
	private Boolean finalizado;
}