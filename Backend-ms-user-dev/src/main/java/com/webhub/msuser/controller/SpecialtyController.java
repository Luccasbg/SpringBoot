package com.webhub.msuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webhub.msuser.entity.Specialty;
import com.webhub.msuser.service.SpecialtyService;

@RestController
@RequestMapping(value = "/specialties")
public class SpecialtyController {

	@Autowired
	private SpecialtyService service;
	
	@GetMapping
	public ResponseEntity<List<Specialty>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Specialty> add(@RequestBody Specialty specialty) {
		return ResponseEntity.ok(service.add(specialty));
	}
}
