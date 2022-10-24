package com.matricula.faculdade.controllers;

import com.matricula.faculdade.dto.MateriaDTO;
import com.matricula.faculdade.services.MateriaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("v1/materia")
public class MateriaController {

	private MateriaService materiaService;

	@PostMapping
	private MateriaDTO create(@Valid @RequestBody MateriaDTO materiaDTO) {
		return materiaService.create( materiaDTO );
	}


}
