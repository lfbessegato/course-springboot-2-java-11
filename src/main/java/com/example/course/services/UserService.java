package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;

/* 
 * Será implementado a busca por todos os usuários e por usuário por Id.
 */
@Service // Registra a classe como um componente de Serviço
public class UserService {

	@Autowired //  Para fazer as dependencias automáticas
	private UserRepository repository;
	
	//Método para retornar todos os Users
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
