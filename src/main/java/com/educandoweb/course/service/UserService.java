package com.educandoweb.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;


// class intermediaria entre controle e repository com regras de negocio
// anotação de registro da classe service para injeção automatica via autowired

@Service
public class UserService {

// dependencia do user repository com injeção transparente autowired
	
	@Autowired
	private UserRepository repository;
	
// metodo service q repassa a chamada para repository.findAll	
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
/* User para retornar
 * metodo com id identificando o usuario e 
 * o objeto user com os dados a serem atualizados
 * getOne prepara o obj monitorado par atz e dps efetuar uma operaçao
 */
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
/*metodo q atz entity com base no q chegou com obj 
 */
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
 }
