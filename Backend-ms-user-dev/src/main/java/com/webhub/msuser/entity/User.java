package com.webhub.msuser.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Indexed(unique=true)
	private String _id;
	
	@Indexed(unique=true)
	private String email;
	
	private String name, user, password;

	private LocalDate birthDate;
	
	private String image_base64;
	
    private LocalDateTime dateTimeRegistration;
    
    private String description;
	
	private List<Role> roles = new ArrayList<>();
	private List<Specialty> specialties = new ArrayList<>();
}
