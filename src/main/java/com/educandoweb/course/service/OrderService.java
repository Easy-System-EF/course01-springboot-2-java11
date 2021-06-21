package com.educandoweb.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;


// class intermediaria entre controle e repository com regras de negocio
// anotação de registro da classe service para injeção automatica via autowired

@Service
public class OrderService {

// dependencia do user repository com injeção transparente autowired
	
	@Autowired
	private OrderRepository repository;
	
// metodo service q repassa a chamada para repository.findAll	
	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
 }
