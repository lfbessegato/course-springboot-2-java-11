package com.example.course.resources;

import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;
import com.example.course.services.UserService;

@RestController
@RequestMapping(value="/users") // Classe User
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//Para retornar requisições na Web
	//Espera uma classe genérica no caso classe User
	@GetMapping
	public ResponseEntity<List<User>> findAll(){ 
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
