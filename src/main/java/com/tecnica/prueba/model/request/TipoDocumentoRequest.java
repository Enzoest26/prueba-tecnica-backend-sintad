package com.tecnica.prueba.model.request;

import lombok.Data;

@Data
public class TipoDocumentoRequest 
{
	private String codigo;
	
	private String nombre;
	
	private String descripcion;
	
	private Integer estado;
}
