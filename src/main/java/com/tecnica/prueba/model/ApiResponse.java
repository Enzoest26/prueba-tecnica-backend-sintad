package com.tecnica.prueba.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
public class ApiResponse {
	
	private String codeStatus;
	private String mensaje;
	
	private Object data;
	
	@Builder.Default
	private LocalDateTime fechaActual = LocalDateTime.now();
}
