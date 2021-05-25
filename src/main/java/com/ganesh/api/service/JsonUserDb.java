package com.ganesh.api.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ganesh.api.model.User;


@Service
public class JsonUserDb {
	
	private static List<User> users;
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	static {
		try {
			File file = ResourceUtils.getFile("classpath:user.credentials.json");
		    users = mapper.readValue(file, new TypeReference<List<User>>() { 	
		    });
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public Optional<User> findByUsername(String username) {
		return users.stream().filter(user -> user.getUsername()
				                       .equals(username)).findFirst();
	}

	

}
