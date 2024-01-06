package com.tecnica.prueba.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;

public class ClaseUtil {

	public static <T, D> T dtoToEntity(Class<T> entidad, Class<D> dto) throws IllegalArgumentException, IllegalAccessException {
		
		if(entidad.isAnnotationPresent(Entity.class)) {
			Field[] entityFieldArray = entidad.getFields();
			Field[] dtoFieldArray = dto.getFields();
			for (Field entityField : entityFieldArray) {
		        entityField.setAccessible(true);

		        for (Field dtoField : dtoFieldArray) {
		            if (entityField.getName().equals(dtoField.getName())) {
		                dtoField.setAccessible(true);

		                Object valor = dtoField.get(dto);
		                entityField.set(entidad, valor);
		                break;
		            }
		        }
		    }
		}
		return null;
	}
	
	public static <T, D> List<D> listEntityToListDto(List<T> list, Class<D> dto) throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		List<D> listDto = new ArrayList<>();
		
		for (T entidad : list) {
	        D dtoClass = dto.newInstance();

	        Field[] entityFieldArray = entidad.getClass().getDeclaredFields();
	        Field[] dtoFieldArray = dto.getDeclaredFields();

	        for (Field entityField : entityFieldArray) {
	            entityField.setAccessible(true);

	            for (Field dtoField : dtoFieldArray) {
	                if (entityField.getName().equals(dtoField.getName())) {
	                    dtoField.setAccessible(true);

	                    Object valor = entityField.get(entidad);
	                    dtoField.set(dtoClass, valor);
	                    break;
	                }
	            }
	        }
	        listDto.add(dtoClass);
	    }	
		return listDto;
	}
}
