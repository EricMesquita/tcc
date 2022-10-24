package com.matricula.faculdade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.matricula.faculdade.entities")
public class MatriculaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatriculaApplication.class, args);
	}

}
