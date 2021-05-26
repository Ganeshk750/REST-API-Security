package com.ganesh.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.api.model.AuthoritiesEntity;
import com.ganesh.api.model.UserEntity;
import com.ganesh.api.model.UserRoleEntity;

/**
 * @Ptoject: books-ws
 * @Author: Ganesh
 * @Date: May 26, 2021
 */

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Integer> {

	UserEntity findByUserEntity(UserEntity userEntity);
}
