package com.transaction.transaction.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno", allocationSize = 1)
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluno")
	private Long id;

	private String nome;

	@OneToMany(mappedBy = "aluno")
	private List<Matricula> matricula;

	private String documento;

}

