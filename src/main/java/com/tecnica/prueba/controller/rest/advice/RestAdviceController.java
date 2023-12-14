package com.tecnica.prueba.controller.rest.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tecnica.prueba.exception.AutenticacionException;
import com.tecnica.prueba.exception.ItemNoEncontradoException;

@RestControllerAdvice
public class RestAdviceController 
{
	@ExceptionHandler(ItemNoEncontradoException.class)
	public ResponseEntity<?> errorItemNoEncontradoException(ItemNoEncontradoException ex)
	{
		ex.printStackTrace();
		Map<String, Object> response = new HashMap<>();
		response.put("mensajeError", ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AutenticacionException.class)
	public ResponseEntity<?> errorAutenticacionException(AutenticacionException ex)
	{
		ex.printStackTrace();
		Map<String, Object> response = new HashMap<>();
		response.put("mensajeError", ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> errorDataIntegrityViolationException(DataIntegrityViolationException ex)
	{
		ex.printStackTrace();
		Map<String, Object> response = new HashMap<>();
		response.put("mensajeError", ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> errorException(Exception ex)
	{
		ex.printStackTrace();
		Map<String, Object> response = new HashMap<>();
		response.put("mensajeError", ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
