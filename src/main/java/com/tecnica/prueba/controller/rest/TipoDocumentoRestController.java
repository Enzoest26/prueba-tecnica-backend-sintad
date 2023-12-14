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

import com.tecnica.prueba.model.TipoDocumento;
import com.tecnica.prueba.model.request.TipoDocumentoRequest;
import com.tecnica.prueba.service.ITipoDocumentoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tipos-documentos")
public class TipoDocumentoRestController 
{
	private ITipoDocumentoService tipoDocumentoService;
	
	@GetMapping
	public ResponseEntity<List<TipoDocumento>> listarTodos()
	{
		List<TipoDocumento> lstTipoDocumento = this.tipoDocumentoService.listarTodos();	
		return new ResponseEntity<List<TipoDocumento>>(lstTipoDocumento, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoDocumento> buscarPorId(@PathVariable Long id)
	{
		return ResponseEntity.of(this.tipoDocumentoService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<TipoDocumento> registrarTipoDocumento(@RequestBody TipoDocumentoRequest request)
	{
		return new ResponseEntity<TipoDocumento>(this.tipoDocumentoService.registrarTipoDocumento(request), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoDocumento> actualizarTipoDocumento(@PathVariable Long id,@RequestBody TipoDocumentoRequest request)
	{
		return ResponseEntity.of(this.tipoDocumentoService.actualizarTipoDocumento(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarTipoDocumento(@PathVariable Long id)
	{
		this.tipoDocumentoService.eliminarTipoDocumento(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
