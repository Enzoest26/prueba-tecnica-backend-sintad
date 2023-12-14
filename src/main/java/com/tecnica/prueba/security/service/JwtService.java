package com.tecnica.prueba.security.service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService 
{
	public static final String SECRET_CODE= "TExBVkUgU0VDUkVUQSAtIFNJTlRBRCAtIFBSVUVCQSBURUNOSUNB";
	
	public String generarToken(String user) 
	{
		return Jwts.builder()
				.setSubject(user)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
				.signWith(this.obtenerLlave(), SignatureAlgorithm.HS256).compact();
	}
	
	private Key obtenerLlave() 
	{
		byte[] llaveBytes = Decoders.BASE64.decode(SECRET_CODE);
		return Keys.hmacShaKeyFor(llaveBytes);
	}
	
	public <T> T extraerClaim(String token, Function<Claims, T> claimsResolver)
	{ 
        final Claims claims = Jwts 
                .parserBuilder() 
                .setSigningKey(this.obtenerLlave()) 
                .build() 
                .parseClaimsJws(token) 
                .getBody(); 
        return claimsResolver.apply(claims); 
    } 
	
	private Date obtenerExpiracion(String token)
	{
		return this.extraerClaim(token, Claims::getExpiration);
	}
	
	private Boolean isTokenExpired(String token)
	{
		return this.obtenerExpiracion(token).before(new Date());
	}
	
	public String extraerUsername(String token) 
	{ 
        return extraerClaim(token, Claims::getSubject); 
    } 
	
	public Boolean validarToken(String token, UserDetails userDetails)
	{
		String user = this.extraerUsername(token);
		return (user.equals(userDetails.getUsername()) && !this.isTokenExpired(token));
	}
}
