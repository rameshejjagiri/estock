package com.estock.company.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handle(MethodArgumentNotValidException ex) {
		// all the failed validation, can be more than one
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			System.out.println(errorMessage);
			errors.put(fieldName, errorMessage);
		});

		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Map<String, String>> nullPointerExceptionHandler(NullPointerException ex) {

		Map<String, String> errors = new HashMap<>();

		errors.put("message", "Data not available");

		return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
	}
}