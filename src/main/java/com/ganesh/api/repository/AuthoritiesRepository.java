package com.ganesh.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.api.model.AuthoritiesEntity;
import com.ganesh.api.model.UserEntity;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 25, 2021
 */

@Repository
public interface AuthoritiesRepository extends CrudRepository<AuthoritiesEntity, Integer> {

	UserEntity findByUserEntity(UserEntity userEntity);
}
