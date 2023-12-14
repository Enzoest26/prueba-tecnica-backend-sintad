package com.tecnica.prueba.service;

import java.util.List;
import java.util.Optional;

import com.tecnica.prueba.model.TipoContribuyente;
import com.tecnica.prueba.model.request.TipoContribuyenteRequest;

public interface ITipoContribuyenteService 
{
	public List<TipoContribuyente> listarTodos();
	
	public TipoContribuyente registrarTipoContribuyente(TipoContribuyenteRequest request);
	
	public Optional<TipoContribuyente> actualizarTipoContribuyente(Long id,TipoContribuyenteRequest request);
	
	public void eliminarTipoContribuyente(Long id);
	
	public Optional<TipoContribuyente> buscarPorId(Long id);
}
