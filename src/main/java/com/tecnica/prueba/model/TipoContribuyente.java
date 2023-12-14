package com.tecnica.prueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * Clase persitente representa la <b>Tipo Contribuyente</b> en la base de datos
 * 
 * */
@Entity
@Table(name = "tb_tipo_contribuyente")
@Data
public class TipoContribuyente 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_contribuyente")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "estado")
	private Integer estado;
}
