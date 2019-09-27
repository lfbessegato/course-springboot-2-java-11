package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Category;
import com.example.course.repositories.CategoryRepository;

/* 
 * Será implementado a busca por todos os usuários e por usuário por Id.
 */
@Service // Registra a classe como um componente de Serviço
public class CategoryService {

	@Autowired //  Para fazer as dependencias automáticas
	private CategoryRepository repository;
	
	//Método para retornar todos os Categorys
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
