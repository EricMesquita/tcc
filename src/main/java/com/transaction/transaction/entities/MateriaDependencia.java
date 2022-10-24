package com.transaction.transaction.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_materia_dependencia", sequenceName = "seq_materia_dependencia", allocationSize = 1)
public class MateriaDependencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_materia_dependencia")
	private Long id;

	private Long materiaId;

	private Long materiaDependenciaId;
}
