package com.tecnica.prueba.commons.service;

import java.util.List;

public interface IBaseService<T> {
	
	public T registrar(T entidad);
	
	public T actualizar(T entidad);
	
	public void eliminar(T eliminar);
	
	public List<T> buscarTodos();
}
