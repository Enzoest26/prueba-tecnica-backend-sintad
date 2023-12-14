package com.tecnica.prueba.security.login.impl;

import org.springframework.stereotype.Service;

import com.tecnica.prueba.exception.AutenticacionException;
import com.tecnica.prueba.model.request.LoginRequest;
import com.tecnica.prueba.model.response.LoginResponse;
import com.tecnica.prueba.security.login.ILoginService;
import com.tecnica.prueba.security.service.JwtService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LoginService implements ILoginService
{
	private static final String USERNAME = "ADMIN";
	private static final String PASSWORD = "ADMIN_ADMIN";
	
	private JwtService jwtService;
	
	
	@Override
	public LoginResponse loguear(LoginRequest request) 
	{
		if(request.getUsername().equals(USERNAME) && request.getContrasenia().equals(PASSWORD))
		{
			return LoginResponse.builder().token(this.jwtService.generarToken(request.getUsername())).build();
		}
			
		throw new AutenticacionException();
	}

}
