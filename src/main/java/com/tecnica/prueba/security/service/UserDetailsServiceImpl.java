package com.tecnica.prueba.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		//Se debe agregar logica de consulta a BD
		String user = "ADMIN";
		String password = "ADMIN_ADMIN";
		if(user.equals(username))
		{
			return User.builder()
					.username(user)
					.password(password)
					.roles("ADMIN")
					.build();
		}
		throw new UsernameNotFoundException("Usuario no existente");
	}

}
