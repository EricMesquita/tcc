package com.transaction.transaction.controllers;

import com.transaction.transaction.dto.AlunoDTO;
import com.transaction.transaction.dto.MateriaDTO;
import com.transaction.transaction.dto.MatriculaDTO;
import com.transaction.transaction.services.MateriaService;
import com.transaction.transaction.services.MatriculaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("v1/matricula")
public class MatriculaController {

	private MatriculaService matriculaService;

	@PostMapping
	private MatriculaDTO create(@Valid @RequestBody MatriculaDTO matriculaDTO) {
		return matriculaService.create( matriculaDTO );
	}

}
