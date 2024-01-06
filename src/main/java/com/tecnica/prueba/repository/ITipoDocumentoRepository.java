package com.tecnica.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnica.prueba.model.TipoDocumento;

@Repository
public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento, Long>{

}
