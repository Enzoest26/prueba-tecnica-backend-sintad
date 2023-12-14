package com.tecnica.prueba.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnica.prueba.model.request.LoginRequest;
import com.tecnica.prueba.security.login.ILoginService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginRestController 
{
	private ILoginService loginService;
	
	@PostMapping
	public ResponseEntity<?> loguear(@RequestBody LoginRequest request)
	{
		return new ResponseEntity<>(this.loginService.loguear(request), HttpStatus.OK);
	}
}
