package com.ganesh.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ganesh.api.model.BooksWsAuthenticationEntryPoint;
import com.ganesh.api.service.impl.UserDetailsServiceImpl;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 24, 2021
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserDetailsServiceImpl userDetailsService;
	private BooksWsAuthenticationEntryPoint bookWsAuthenticationEntryPoint;
	
	public SecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImpl userDetailsService,
			BooksWsAuthenticationEntryPoint bookWsAuthenticationEntryPoint) {
		super();
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetailsService = userDetailsService;
		this.bookWsAuthenticationEntryPoint = bookWsAuthenticationEntryPoint;
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable()
			 .authorizeRequests().anyRequest().authenticated()
			 .and().httpBasic().authenticationEntryPoint(bookWsAuthenticationEntryPoint);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
   
}
