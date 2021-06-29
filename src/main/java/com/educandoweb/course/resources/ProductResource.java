package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.service.ProductService;

//1a recurso web implementado pelo recurso rest
//2a nome do resurso com caminho(associação) "/entitie" 
@RestController
@RequestMapping(value = "/products")
public class ProductResource {

// dependencia service transparente	
	@Autowired
	private ProductService service;
	
// indica resposta ao tipo get do http	
	@GetMapping
// tipo especifico para retonar requisição web c/ tipo generic	
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
// retorna resposta ok, corpo da resposta do usuario...		
		return ResponseEntity.ok( ).body(list);
	}

// requisicao com id dentro da url
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
}
