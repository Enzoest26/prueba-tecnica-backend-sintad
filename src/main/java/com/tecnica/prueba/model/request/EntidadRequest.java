package com.tecnica.prueba.model.request;

import lombok.Data;

@Data
public class EntidadRequest 
{
	
	private Long idTipoDocumento;
	
	private String nroDocumento;
	
	private String razonSocial;
	
	private String nombreComercial;
	
	private Long idTipoContribuyente;
	
	private String direccion;
	
	private String telefono;
	
	private Integer estado;
}
