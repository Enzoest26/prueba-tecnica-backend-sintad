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

import com.tecnica.prueba.model.TipoContribuyente;
import com.tecnica.prueba.model.request.TipoContribuyenteRequest;
import com.tecnica.prueba.service.ITipoContribuyenteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tipos-contribuyentes")
@AllArgsConstructor
public class TipoContribuyenteRestController 
{
	private ITipoContribuyenteService tipoContribuyenteService;
	
	@GetMapping
	public ResponseEntity<List<TipoContribuyente>> listarTodos()
	{
		return new ResponseEntity<List<TipoContribuyente>>(this.tipoContribuyenteService.listarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoContribuyente> buscarPorId(@PathVariable Long id)
	{
		return ResponseEntity.of(this.tipoContribuyenteService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<TipoContribuyente> registrarTipoContribuyente(@RequestBody TipoContribuyenteRequest request)
	{
		return new ResponseEntity<TipoContribuyente>(this.tipoContribuyenteService.registrarTipoContribuyente(request), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoContribuyente> actualizarTipoContribuyente(@PathVariable Long id,@RequestBody TipoContribuyenteRequest request)
	{
		return ResponseEntity.of(this.tipoContribuyenteService.actualizarTipoContribuyente(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarTipoContribuyente(@PathVariable Long id)
	{
		this.tipoContribuyenteService.eliminarTipoContribuyente(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
