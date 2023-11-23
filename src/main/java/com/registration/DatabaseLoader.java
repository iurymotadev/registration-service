package com.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.registration.model.User;
import com.registration.service.RegisterUserService;

@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private final RegisterUserService service;

	public DatabaseLoader(RegisterUserService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) {
		User entity1 = new User("Iury", "iury@email.com", "iurypassword");
		User entity2 = new User("Julia", "julia@email.com", "iurypassword");
		User entity3 = new User("Jane", "jane@email.com", "janepassword");
		User entity4 = new User("Igor", "igor@email.com", "igorpassword");
		User entity5 = new User("Iago", "iago@email.com", "iagopassword");
		User entity6 = new User("Cassio", "cassio@email.com", "cassiopassword");
		User entity7 = new User("Marcos", "marcos@email.com", "marcospassword");
		User entity8 = new User("Maria", "maria@email.com", "mariapassword");

		service.registerUser(entity1);
		service.registerUser(entity2);
		service.registerUser(entity3);
		service.registerUser(entity4);
		service.registerUser(entity5);
		service.registerUser(entity6);
		service.registerUser(entity7);
		service.registerUser(entity8);
	}
}
