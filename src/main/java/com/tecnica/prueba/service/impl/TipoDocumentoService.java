package com.tecnica.prueba.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tecnica.prueba.model.TipoDocumento;
import com.tecnica.prueba.model.request.TipoDocumentoRequest;
import com.tecnica.prueba.repository.ITipoDocumentoRepository;
import com.tecnica.prueba.service.ITipoDocumentoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoDocumentoService implements ITipoDocumentoService
{
	private ITipoDocumentoRepository tipoDocumentoRepository;

	@Override
	public Optional<TipoDocumento> buscarPorId(Long id)
	{
		return this.tipoDocumentoRepository.findById(id);
	}

	@Override
	public List<TipoDocumento> listarTodos() 
	{
		return this.tipoDocumentoRepository.findAll();
	}

	@Override
	public TipoDocumento registrarTipoDocumento(TipoDocumentoRequest request) 
	{
		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setCodigo(request.getCodigo());
		tipoDocumento.setDescripcion(request.getDescripcion());
		tipoDocumento.setEstado(request.getEstado());
		tipoDocumento.setNombre(request.getNombre());
		return this.tipoDocumentoRepository.save(tipoDocumento);
	}

	@Override
	public Optional<TipoDocumento> actualizarTipoDocumento(Long id, TipoDocumentoRequest request)
	{
		
		return this.tipoDocumentoRepository.findById(id).map(tipoDocumento -> {
			tipoDocumento.setCodigo(request.getCodigo());
			tipoDocumento.setDescripcion(request.getDescripcion());
			tipoDocumento.setEstado(request.getEstado());
			tipoDocumento.setNombre(request.getNombre());
			return this.tipoDocumentoRepository.save(tipoDocumento);
		});
	}

	@Override
	public void eliminarTipoDocumento(Long id) 
	{
		this.tipoDocumentoRepository.deleteById(id);
	}

}
