package com.tecnica.prueba.model;

import lombok.Data;

@Data
public class BaseResponse 
{
	private String statusCode;
	private String msjDescripcion;
	private Boolean error;
	private Object data;
}
