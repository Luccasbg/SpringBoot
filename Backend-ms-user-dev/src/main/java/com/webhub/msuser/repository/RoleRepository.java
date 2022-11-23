package com.webhub.msuser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webhub.msuser.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	boolean existsByRoleName(String roleName);
}
