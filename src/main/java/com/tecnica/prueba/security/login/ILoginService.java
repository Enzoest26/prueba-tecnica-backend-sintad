package com.tecnica.prueba.security.login;

import com.tecnica.prueba.model.request.LoginRequest;
import com.tecnica.prueba.model.response.LoginResponse;

public interface ILoginService 
{
	public LoginResponse loguear(LoginRequest request);
}
