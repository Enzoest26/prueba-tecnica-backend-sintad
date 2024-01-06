package com.tecnica.prueba.security;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecnica.prueba.model.ApiResponse;
import com.tecnica.prueba.security.service.JwtService;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
	
	private JwtService jwtService;
	
	private ObjectMapper objectMapper;
	
	@Qualifier("userDetailsServiceImpl")
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String user = null;
		try {
			if(authHeader != null && authHeader.startsWith("Bearer "))
			{
				token = authHeader.substring(7);
				user = this.jwtService.extraerUsername(token);
			}
			
			if(user != null && SecurityContextHolder.getContext().getAuthentication() == null)
			{
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(user);
				
					if(this.jwtService.validarToken(token, userDetails)) 
					{
						UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(
			                    userDetails,
			                    null,
			                    userDetails.getAuthorities());
						authToken.setDetails(userDetails);
						authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(authToken);
					}
				} 
				
		}
		catch (Exception e)
		{
			PrintWriter writer = response.getWriter();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			if (e instanceof ExpiredJwtException)
			{	
				response.setStatus(HttpStatus.FORBIDDEN.value());
				writer.print(objectMapper.writeValueAsString(this.crearResponse(String.valueOf(HttpStatus.FORBIDDEN.value()), "Token invalido", null)));
			}
			else 
			{
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				writer.print(objectMapper.writeValueAsString(this.crearResponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "Error desconocido", null)));
			}
			writer.flush();
			return;
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	private ApiResponse crearResponse(String codeStatus, String mensaje, String data) {
		return ApiResponse.
				builder().
				codeStatus(codeStatus).
				mensaje(mensaje).
				data(data).
				build();
	}
}
