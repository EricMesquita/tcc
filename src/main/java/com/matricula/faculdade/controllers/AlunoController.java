package com.matricula.faculdade.controllers;

import com.matricula.faculdade.dto.AlunoDTO;
import com.matricula.faculdade.dto.AlunoEMatriculasDTO;
import com.matricula.faculdade.services.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("v1/aluno")
public class AlunoController {

	private AlunoService alunoService;

	@PostMapping
	private AlunoDTO create(@Valid @RequestBody AlunoDTO alunoDTO) {
		return alunoService.create( alunoDTO );
	}

	@GetMapping("/{accountId}")
	private AlunoDTO find(@PathVariable( "accountId" ) Long accountId) {
		return alunoService.find( accountId );
	}

	@GetMapping("/{accountId}/matricula")
	private AlunoEMatriculasDTO findMatriculas(@PathVariable( "accountId" ) Long accountId) {
		return alunoService.findMatriculas( accountId );
	}
}
