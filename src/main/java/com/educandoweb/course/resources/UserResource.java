package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//  1a recurso web implementado pelo recurso rest
//  2a nome do resurso com caminho "/entitie" 
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
// indica resposta ao tipo get do http	
	@GetMapping
// tipo especifico para retonar requisição web c/ tipo generic	
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "999999", "maria@gmail.com", "123456");
// retorna resposta ok, corpo da resposta do usuario...		
		return ResponseEntity.ok( ).body(u);
	}

}
