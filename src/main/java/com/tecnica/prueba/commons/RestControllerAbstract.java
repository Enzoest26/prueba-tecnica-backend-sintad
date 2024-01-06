package com.tecnica.prueba.commons;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecnica.prueba.model.request.TipoDocumentoRequest;
import com.tecnica.prueba.service.base.IBaseService;
import com.tecnica.prueba.util.ClaseUtil;

public class RestControllerAbstract<T, R extends IBaseService<T>, D>
{
	private R service;
	
	public RestControllerAbstract(R service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<D>> buscarTodos() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		Class<T> claseEntidad = (Class<T>) ((ParameterizedType) getClass()
	            .getGenericSuperclass())
	            .getActualTypeArguments()[0];
		Class<D> claseDto = (Class<D>) ((ParameterizedType) getClass()
	            .getGenericSuperclass())
	            .getActualTypeArguments()[0];
	    
		return new ResponseEntity<List<D>>(ClaseUtil.listEntityToListDto(this.service.buscarTodos(), claseDto), HttpStatus.OK);
	}
}
