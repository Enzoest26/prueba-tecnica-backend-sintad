package com.tecnica.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnica.prueba.model.Entidad;

public interface IEntidadRepository extends JpaRepository<Entidad, Long>{

}
