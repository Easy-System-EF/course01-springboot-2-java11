package com.educandoweb.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;


// class intermediaria entre controle e repository com regras de negocio
// anotação de registro da classe service para injeção automatica via autowired

@Service
public class ProductService {

// dependencia do user repository com injeção transparente autowired
	
	@Autowired
	private ProductRepository repository;
	
// metodo service q repassa a chamada para repository.findAll	
	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Integer id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
 }
