package com.example.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;

@RestController
@RequestMapping(value="/users") // Classe User
public class UserResource {
	
	//Método para criar um endpoint para acessar os usuários
	
	//Para retornar requisições na Web
	//Espera uma classe genérica no caso classe User
	@GetMapping
	public ResponseEntity<User> findAll(){ 
		
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}

}
