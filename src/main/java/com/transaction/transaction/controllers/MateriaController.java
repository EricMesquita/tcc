package com.transaction.transaction.controllers;

import com.transaction.transaction.dto.AlunoDTO;
import com.transaction.transaction.dto.MateriaDTO;
import com.transaction.transaction.entities.Materia;
import com.transaction.transaction.services.AlunoService;
import com.transaction.transaction.services.MateriaService;
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
