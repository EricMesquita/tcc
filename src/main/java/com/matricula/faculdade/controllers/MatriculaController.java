package com.matricula.faculdade.controllers;

import com.matricula.faculdade.dto.MatriculaDTO;
import com.matricula.faculdade.services.MatriculaService;
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
