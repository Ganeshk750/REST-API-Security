package com.ganesh.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.api.model.User;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 24, 2021
 */

@Service
public class UserService {
	
	// private User user = null;
	
	@Autowired
	private JsonUserDb jsonUser;
	
	public UserService() {
		//user = new User("myusername", "$2y$12$iINQIR49Zw8C8lQDDngcvu8JvjPBvF/WQlpjTbNsWGCjQrausGMo2", true);
	}
	
	public User getUserByUsername(String username) {
//		if(user.getUserName().equals(userName)) {
//			return user;
//		}else {
//			return null;
//		}
		Optional<User> optionalUser = jsonUser.findByUsername(username);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
		
	}

}
