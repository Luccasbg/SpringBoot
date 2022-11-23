package com.webhub.msuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webhub.msuser.entity.User;
import com.webhub.msuser.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@PostMapping()
	public ResponseEntity<?> add(@RequestBody User user){
		User new_user = service.add(user);

		if (new_user == null) {
			return ResponseEntity.badRequest().body("Atributo(s) inválido(s)! Insira atributos válidos principalmente nos campos roles e specialties.");
		} else {
			return ResponseEntity.ok(new_user);
		}

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable String id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok(service.findByEmail(email));
	}
}
