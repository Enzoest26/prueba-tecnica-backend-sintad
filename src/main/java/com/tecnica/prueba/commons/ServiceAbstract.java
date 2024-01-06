package com.tecnica.prueba.commons;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnica.prueba.service.base.IBaseService;

public class ServiceAbstract<T, ID, R extends JpaRepository<T, ID>> implements IBaseService<T>
{
	private R repository;
	
	public ServiceAbstract(R base){
		this.repository = base;
	}
	
	public T registrar(T entidad) {
		return this.repository.save(entidad);
	}
	
	public T actualizar(T entidad) {
		return this.repository.save(entidad);
	}
	
	public void eliminar(T entidad) {
		this.repository.delete(entidad);
	}
	
	public List<T> buscarTodos() {
		return this.repository.findAll();
	}
	
}
