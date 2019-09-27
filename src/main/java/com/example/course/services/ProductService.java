package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Product;
import com.example.course.repositories.ProductRepository;

/* 
 * Será implementado a busca por todos os usuários e por usuário por Id.
 */
@Service // Registra a classe como um componente de Serviço
public class ProductService {

	@Autowired //  Para fazer as dependencias automáticas
	private ProductRepository repository;
	
	//Método para retornar todos os Products
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
