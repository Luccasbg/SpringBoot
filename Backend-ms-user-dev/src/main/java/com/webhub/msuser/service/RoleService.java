package com.webhub.msuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webhub.msuser.entity.Role;
import com.webhub.msuser.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;
	
	public List<Role> findAll() {
		List<Role> obj = repository.findAll();
		return obj;
	}
	
	public Role add(Role role) {
		Role obj = repository.save(role);
		return obj;
	}
}
