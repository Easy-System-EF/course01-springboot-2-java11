package com.educandoweb.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.service.exceptions.DatabaseException;
import com.educandoweb.course.service.exceptions.ResourceNotFoundException;


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

/*
 * trocando o obj.get por obj.orElse -> no caso de nao existir, lança uma exceção
 */
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
//		return obj.get();
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
/*
 * empty -> não encontrado	
 * integrity -> violação de integridade (tem pedido(s) para o User)
 * acrescenta tratamento no handler 
 */
	public void delete(Long id) {
		try {			
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
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
	private void updateData(User entity	, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
 }
