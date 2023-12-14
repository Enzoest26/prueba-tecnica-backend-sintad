package com.tecnica.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnica.prueba.model.TipoDocumento;

public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento, Long>{

}
