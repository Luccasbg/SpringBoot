package com.webhub.msuser.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webhub.msuser.entity.Role;
import com.webhub.msuser.entity.Specialty;
import com.webhub.msuser.entity.User;
import com.webhub.msuser.repository.RoleRepository;
import com.webhub.msuser.repository.SpecialtyRepository;
import com.webhub.msuser.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private SpecialtyRepository specialtyRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<User> findAll() {
		List<User> obj = repository.findAll();
		return obj;
	}

	public User add(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setDateTimeRegistration(LocalDateTime.now());

		List<Specialty> specialties = user.getSpecialties();

		for (Specialty specialty : specialties) {
			if (!specialtyRepository.existsBySpecialtyName(specialty.getSpecialtyName())) {
				return null;
			}
		}

		List<Role> roles = user.getRoles();

		for (Role role : roles) {
			if (!roleRepository.existsByRoleName(role.getRoleName())) {
				return null;
			}
		}

		repository.save(user);
		return user;
	}

	public User findById(String id) {
		User obj = repository.findById(id).get();
		return obj;
	}

	public User findByEmail(String email) {
		User obj = repository.findByEmail(email);
		return obj;
	}
}
