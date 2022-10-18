package com.transaction.transaction.controllers;

import com.transaction.transaction.dto.AlunoDTO;
import com.transaction.transaction.services.AlunoService;
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
}
