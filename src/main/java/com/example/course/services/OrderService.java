package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Order;
import com.example.course.repositories.OrderRepository;

/* 
 * Será implementado a busca por todos os usuários e por usuário por Id.
 */
@Service // Registra a classe como um componente de Serviço
public class OrderService {

	@Autowired //  Para fazer as dependencias automáticas
	private OrderRepository repository;
	
	//Método para retornar todos os Orders
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
