package com.webhub.msuser.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Indexed(unique=true)
	private String roleName;
	
}