package com.tecnica.prueba.commons;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecnica.prueba.service.base.IBaseService;
import com.tecnica.prueba.util.EntidadUtil;

public class RestControllerAbstract<T, R extends IBaseService<T>, D>
{
	private R service;
	
	public RestControllerAbstract(R service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<T>> buscarTodos(){
		Class<T> claseEntidad = (Class<T>) ((ParameterizedType) getClass()
	            .getGenericSuperclass())
	            .getActualTypeArguments()[0];
		System.out.println(claseEntidad);
	    EntidadUtil.dtoToEntity(claseEntidad);
		return new ResponseEntity<List<T>>(this.service.buscarTodos(), HttpStatus.OK);
	}
}
