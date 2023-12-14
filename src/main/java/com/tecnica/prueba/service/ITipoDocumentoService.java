package com.tecnica.prueba.service;

import java.util.List;
import java.util.Optional;

import com.tecnica.prueba.model.TipoDocumento;
import com.tecnica.prueba.model.request.TipoDocumentoRequest;

public interface ITipoDocumentoService 
{
	public Optional<TipoDocumento> buscarPorId(Long id);
	
	public List<TipoDocumento> listarTodos();
	
	public TipoDocumento registrarTipoDocumento(TipoDocumentoRequest request);
	
	public Optional<TipoDocumento> actualizarTipoDocumento(Long id,TipoDocumentoRequest request);
	
	public void eliminarTipoDocumento(Long id);
}
