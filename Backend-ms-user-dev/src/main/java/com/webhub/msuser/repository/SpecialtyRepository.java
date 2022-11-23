package com.webhub.msuser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webhub.msuser.entity.Specialty;

public interface SpecialtyRepository extends MongoRepository<Specialty, String> {

	boolean existsBySpecialtyName(String specialtyName);
}
