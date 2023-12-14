package com.tecnica.prueba.service;

import java.util.List;
import java.util.Optional;

import com.tecnica.prueba.model.Entidad;
import com.tecnica.prueba.model.request.EntidadRequest;

/**
 * Interfaz donde expone metodos de mantenimiento de la clase persitente {@link Entidad}
 * 
 * */
public interface IEntidadService 
{
	/**
	 * Metodo de listado de todos las <b>Entidades</b>
	 * @return Retorna una lista que contiende todas la entidades existentes
	 * */
	public List<Entidad> listarTodos();
	
	/**
	 * Metodo de registro de una <b>Entidad</b>
	 * @param request Objeto de nuevos datos a la entidad persitente de tipo {@link EntidadRequest}
	 * @return Retorna la Entidad registrada
	 * */
	public Entidad registrarEntidad(EntidadRequest request);
	
	/**
	 * Metodo de actualizacion de una entidad por el identificador
	 * @param id Identificador unico de la entidad
	 * @param request Objeto de nuevos datos a la entidad persitente de tipo {@link EntidadRequest}
	 * @return Retorna una Optional, en caso de no existir retorna un null.
	 * */
	public Optional<Entidad> actualizarEntidad(Long id, EntidadRequest request);
	
	/**
	 * Metodo de eliminacion de una entidad
	 * @param id Identificador unico de la entidad
	 * */
	public void eliminarEntidad(Long id);
	
	/**
	 * Metodo de listado de todos las <b>Entidades</b>
	 * @return Retonra una lista que contiende todas la entidades existentes
	 * */
	public Optional<Entidad> buscarPorId(Long id);
}
