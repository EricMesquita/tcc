package com.matricula.faculdade.exceptions;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matricula.faculdade.dto.ErrorDTO;

@ControllerAdvice
@RestController
@AllArgsConstructor
public class ExceptionAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach( (error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put( fieldName, errorMessage );
		} );
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AlunoException.class)
	public ErrorDTO accountException(AlunoException ex) {
		return ErrorDTO.builder().message( ex.getMessage() ).build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MateriaException.class)
	public ErrorDTO materiaException(AlunoException ex) {
		return ErrorDTO.builder().message( ex.getMessage() ).build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MatriculaException.class)
	public ErrorDTO matriculaException(AlunoException ex) {
		return ErrorDTO.builder().message( ex.getMessage() ).build();
	}

}
