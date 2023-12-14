package com.tecnica.prueba.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnica.prueba.model.Entidad;
import com.tecnica.prueba.model.request.EntidadRequest;
import com.tecnica.prueba.service.IEntidadService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/entidades")
@AllArgsConstructor
public class EntidadRestController 
{
	private IEntidadService entidadService;
	
	
	@GetMapping
	public ResponseEntity<List<Entidad>> listarTodos()
	{
		return new ResponseEntity<List<Entidad>>(this.entidadService.listarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entidad> buscarPorId(@PathVariable Long id)
	{
		return ResponseEntity.of(this.entidadService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Entidad> registrarEntidad(@RequestBody EntidadRequest request)
	{
		return new ResponseEntity<Entidad>(this.entidadService.registrarEntidad(request), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Entidad> actualizarEntidad(@PathVariable Long id,@RequestBody EntidadRequest request)
	{
		return ResponseEntity.of(this.entidadService.actualizarEntidad(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarEntidad(@PathVariable Long id)
	{
		this.entidadService.eliminarEntidad(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
