package com.tecnica.prueba.util;

import java.util.List;

import jakarta.persistence.Entity;

public class EntidadUtil {

	public static <T, D> T dtoToEntity(Class<T> entidad) {
		
		if(entidad.isAnnotationPresent(Entity.class)) {
			System.out.println("Tiene la entidad");
		}
		return null;
	}
}
