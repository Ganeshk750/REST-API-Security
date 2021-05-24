package com.ganesh.api.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 24, 2021
 */

@Component
public class BooksWsAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
 
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		
		response.addHeader("WWW-Authenticate" , "Basic realm= "+ getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		//response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
		PrintWriter writer = response.getWriter();
		writer.println("Basic Authentication requird. Please supply appropriate credentials.");
		//super.commence(request, response, authException);
	}
	
	@Override
	public void afterPropertiesSet() {
		setRealmName("basicRealm");
		super.afterPropertiesSet();
	}
	
}
