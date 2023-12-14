package com.tecnica.prueba.exception;

/**
 * 
 * Exception consiste cuando la autenticacion no es correcta o no disponible.
 * <br>
 * */
public class AutenticacionException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1229089110390293431L;
	
	public final static String mensaje = "Credenciales incorrectas y/o no disponibles";
	
	public AutenticacionException()
	{
		super(mensaje);
	}

}
