package com.tecnica.prueba.service;

import java.util.Optional;

import com.tecnica.prueba.model.TipoDocumento;
import com.tecnica.prueba.service.base.IBaseService;

public interface ITipoDocumentoService extends IBaseService<TipoDocumento>
{
	public Optional<TipoDocumento> buscarPorId(Long id);

}
