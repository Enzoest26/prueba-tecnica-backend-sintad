package com.tecnica.prueba.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tecnica.prueba.commons.ServiceAbstract;
import com.tecnica.prueba.model.TipoDocumento;
import com.tecnica.prueba.repository.ITipoDocumentoRepository;
import com.tecnica.prueba.service.ITipoDocumentoService;

import lombok.AllArgsConstructor;


@Service
public class TipoDocumentoService extends ServiceAbstract<TipoDocumento, Long, ITipoDocumentoRepository> implements ITipoDocumentoService
{

	@Autowired
	public TipoDocumentoService(ITipoDocumentoRepository base) {
		super(base);
	}

/*
	private ITipoDocumentoRepository tipoDocumentoRepository;

	@Override
	public Optional<TipoDocumento> buscarPorId(Long id)
	{
		return this.tipoDocumentoRepository.findById(id);
	}
*/

	@Override
	public Optional<TipoDocumento> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
