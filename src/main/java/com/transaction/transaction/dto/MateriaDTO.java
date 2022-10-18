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
public class MateriaDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	@NotNull(message = "O nome da materia não pode ser nulo")
	@NotEmpty(message = "O nome da materia não pode ser não vazio")
	private String nome;

	@JsonProperty("capacidade")
	@NotNull(message = "A capacidade não pode ser nulo")
	@NotEmpty(message = "A capacidade não pode ser não vazio")
	private Long capacidade;

	@JsonProperty("materia_dependencia")
	private Long materiaDependencia;
}
