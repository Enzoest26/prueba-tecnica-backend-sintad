package com.tecnica.prueba.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tecnica.prueba.exception.ItemNoEncontradoException;
import com.tecnica.prueba.model.Entidad;
import com.tecnica.prueba.model.request.EntidadRequest;
import com.tecnica.prueba.repository.IEntidadRepository;
import com.tecnica.prueba.service.IEntidadService;
import com.tecnica.prueba.service.ITipoContribuyenteService;
import com.tecnica.prueba.service.ITipoDocumentoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntidadService implements IEntidadService
{
	private IEntidadRepository entidadRepository;
	
	private ITipoContribuyenteService tipoContribuyenteService;
	
	private ITipoDocumentoService tipoDocumentoService;
	
	@Override
	public List<Entidad> listarTodos() 
	{
		return this.entidadRepository.findAll();
	}

	@Override
	public Entidad registrarEntidad(EntidadRequest request) 
	{
		Entidad entidad = new Entidad();
		entidad.setDireccion(entidad.getDireccion());
		entidad.setEstado(request.getEstado());
		entidad.setNombreComercial(request.getNombreComercial());
		entidad.setNroDocumento(request.getNroDocumento());
		entidad.setDireccion(request.getDireccion());
		entidad.setObjTipoContribuyente(this.tipoContribuyenteService.buscarPorId(request.getIdTipoContribuyente()).orElse(null));
		entidad.setObjTipoDocumento(this.tipoDocumentoService.buscarPorId(request.getIdTipoDocumento()).orElseThrow(() -> new ItemNoEncontradoException("Tipo Documento no existente")));
		entidad.setRazonSocial(request.getRazonSocial());
		entidad.setTelefono(request.getTelefono());
		return this.entidadRepository.save(entidad);
	}

	@Override
	public Optional<Entidad> actualizarEntidad(Long id, EntidadRequest request) 
	{
		return this.entidadRepository.findById(id).map(entidad -> {
			entidad.setDireccion(entidad.getDireccion());
			entidad.setEstado(request.getEstado());
			entidad.setNombreComercial(request.getNombreComercial());
			entidad.setNroDocumento(request.getNroDocumento());
			entidad.setDireccion(request.getDireccion());
			entidad.setObjTipoContribuyente(this.tipoContribuyenteService.buscarPorId(request.getIdTipoContribuyente()).orElse(null));
			entidad.setObjTipoDocumento(this.tipoDocumentoService.buscarPorId(request.getIdTipoDocumento()).orElseThrow(() -> new ItemNoEncontradoException("Tipo Documento no existente")));
			entidad.setRazonSocial(request.getRazonSocial());
			entidad.setTelefono(request.getTelefono());
			return this.entidadRepository.save(entidad);
		});
	}

	@Override
	public void eliminarEntidad(Long id) 
	{
		this.entidadRepository.deleteById(id);
	}

	@Override
	public Optional<Entidad> buscarPorId(Long id) 
	{
		return this.entidadRepository.findById(id);
	}

}
