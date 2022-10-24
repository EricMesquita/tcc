package com.transaction.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoEMatriculasDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	@NotNull(message = "O nome não pode ser nulo")
	@NotEmpty(message = "O nome não pode ser não vazio")
	private String nome;

	@JsonProperty("documento")
	@NotNull(message = "O número do documento não pode ser nulo")
	@NotEmpty(message = "O número do documento não pode ser não vazio")
	private String documento;

	private List<MatriculaDTO> matriculaDTO;
}
