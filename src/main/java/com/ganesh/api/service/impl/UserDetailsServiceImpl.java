package com.ganesh.api.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ganesh.api.model.User;
import com.ganesh.api.service.UserService;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 24, 2021
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private UserService userService;
	
	public UserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUserName(username);
		if(user != null) {
			return user;
		}else {
			throw new UsernameNotFoundException(username + "does not exist!");
		}
		
	}

}
