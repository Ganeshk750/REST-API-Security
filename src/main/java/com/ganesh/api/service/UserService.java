package com.ganesh.api.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.ganesh.api.model.User;
import com.ganesh.api.model.UserEntity;
import com.ganesh.api.repository.AuthoritiesRepository;
import com.ganesh.api.repository.UserRepository;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 24, 2021
 */

@Service
public class UserService {
	
	private UserRepository userRepository;
	private AuthoritiesRepository authoritiesRepository;

	public UserService(UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
		this.userRepository = userRepository;
		this.authoritiesRepository = authoritiesRepository;
	}

	public User getUserByUsername(String username) {

        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity != null) {
            return createUserFromUserEntity(userEntity);
        } else {
            return null;
        }
    }

    private User createUserFromUserEntity(UserEntity ue) {

        User user = new User(ue.getUsername(), ue.getPassword(), ue.isEnabled());
        user.setAuthorities(ue.getAuthoritiesEntities().stream()
        		           .map(ae -> new SimpleGrantedAuthority(ae.getAuthority()))
        		           .collect(Collectors.toSet()));
        return user;
    }

}
