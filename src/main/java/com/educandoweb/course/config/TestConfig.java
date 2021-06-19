package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

// anotação informando q é uma classe config
// profile = aolication.properties
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

// injeção de dependencia automatica via spring com anotação:
	@Autowired
	private UserRepository userRepository;
	
// metodo da implementacao Command	
	@Override 
	public void run(String... args) throws Exception {
	
		User u1 = new User(null, "Maria Brown", "988888888", "maria@gmail.com", "123456");
		User u2 = new User(null, "Alex Green", "977777777", "alex@gmail.com",  "123456"); 
		
// salvando 
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
	
	
}
