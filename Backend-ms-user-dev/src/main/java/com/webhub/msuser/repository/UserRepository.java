package com.webhub.msuser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webhub.msuser.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
