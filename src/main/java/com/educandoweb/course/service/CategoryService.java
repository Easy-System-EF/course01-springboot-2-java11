package com.educandoweb.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;


// class intermediaria entre controle e repository com regras de negocio
// anotação de registro da classe service para injeção automatica via autowired

@Service
public class CategoryService {

// dependencia do category repository com injeção transparente autowired
	
	@Autowired
	private CategoryRepository repository;
	
// metodo service q repassa a chamada para repository.findAll	
	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
 }
