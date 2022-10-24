package com.matricula.faculdade.controllers;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matricula.faculdade.properties.EnvironmentProperties;

@RestController
@AllArgsConstructor
@RequestMapping("/status")
public class StatusController {

	private EnvironmentProperties environmentProperties;

	@GetMapping()
	public String status() {
		return environmentProperties.getStatus();
	}
}
