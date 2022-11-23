package com.webhub.msuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webhub.msuser.entity.Specialty;
import com.webhub.msuser.repository.SpecialtyRepository;

@Service
public class SpecialtyService {

	@Autowired
	private SpecialtyRepository repository;
	
	public List<Specialty> findAll() {
		List<Specialty> obj = repository.findAll();
		return obj;
	}
	
	public Specialty add(Specialty specialty) {
		Specialty obj = repository.save(specialty);
		return obj;
	}
}
