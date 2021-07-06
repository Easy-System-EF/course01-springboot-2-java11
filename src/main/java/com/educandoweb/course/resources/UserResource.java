package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.UserService;
 
//  1a recurso web implementado pelo recurso rest
//  2a nome do resurso com caminho "/entitie" 
@RestController
@RequestMapping(value = "/users")
public class UserResource {

// dependencia service transparente	
	@Autowired
	private UserService service;
	
// indica resposta ao tipo get do http	
	@GetMapping
// tipo especifico para retonar requisição web c/ tipo generic	
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
// retorna resposta ok, corpo da resposta do usuario...		
		return ResponseEntity.ok( ).body(list);
	}

// requisicao com id dentro da url
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
//		return ResponseEntity.ok().body(obj);
// retorno do codigo201 = criou;		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

/*
	 anotação incluisão
	 chamando o service
	 os dados postados no Postman devem ter os atributos(cpos) identicos aos definidos na classe
	 senão sai null
*/
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
}
