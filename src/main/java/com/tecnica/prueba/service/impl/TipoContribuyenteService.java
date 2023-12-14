package com.tecnica.prueba.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tecnica.prueba.model.TipoContribuyente;
import com.tecnica.prueba.model.request.TipoContribuyenteRequest;
import com.tecnica.prueba.repository.ITipoContribuyenteRepository;
import com.tecnica.prueba.service.ITipoContribuyenteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoContribuyenteService implements ITipoContribuyenteService
{	
	private ITipoContribuyenteRepository tipoContribuyenteRepository;
	
	@Override
	public List<TipoContribuyente> listarTodos()
	{
		return this.tipoContribuyenteRepository.findAll();
	}

	@Override
	public TipoContribuyente registrarTipoContribuyente(TipoContribuyenteRequest request)
	{
		TipoContribuyente tipoContribuyente = new TipoContribuyente();
		tipoContribuyente.setNombre(request.getNombre());
		tipoContribuyente.setEstado(request.getEstado());
		return this.tipoContribuyenteRepository.save(tipoContribuyente);
	}

	@Override
	public Optional<TipoContribuyente> actualizarTipoContribuyente(Long id, TipoContribuyenteRequest request)
	{
		return this.tipoContribuyenteRepository.findById(id).map(tipoContribuyente -> {
			tipoContribuyente.setNombre(request.getNombre());
			tipoContribuyente.setEstado(request.getEstado());
			return this.tipoContribuyenteRepository.save(tipoContribuyente);
		});
	}

	@Override
	public void eliminarTipoContribuyente(Long id)
	{
		this.tipoContribuyenteRepository.deleteById(id);
	}

	@Override
	public Optional<TipoContribuyente> buscarPorId(Long id)
	{
		return this.tipoContribuyenteRepository.findById(id);
	}

}
