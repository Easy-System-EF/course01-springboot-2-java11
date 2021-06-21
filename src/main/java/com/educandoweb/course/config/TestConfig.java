package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

// anotação informando q é uma classe config
// profile = aplication.properties
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

// injeção de dependencia automatica via spring com anotação: user, order...
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
// metodo da implementacao Command	
	@Override 
	public void run(String... args) throws Exception {
	
		User u1 = new User(null, "Maria Brown", "988888888", "maria@gmail.com", "123456");
		User u2 = new User(null, "Alex Green", "977777777", "alex@gmail.com",  "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,  u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITTING_PAYMENT,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITTING_PAYMENT,u1);
		
// salvando 
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));		
	}
	
	
	
	
}