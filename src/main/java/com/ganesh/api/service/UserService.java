package com.ganesh.api.service;

import org.springframework.stereotype.Service;

import com.ganesh.api.model.User;
import com.ganesh.api.model.UserEntity;
import com.ganesh.api.repository.UserRepository;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 24, 2021
 */

@Service
public class UserService {
	
	private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

        return new User(ue.getUsername(), ue.getPassword(), ue.isEnabled());
    }

}
