package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.registration.model.RegisterDTO;
import com.registration.model.User;
import com.registration.service.RegisterUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	RegisterUserService service;
	
	@PostMapping("/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	public RegisterDTO registrateUser(@Valid @RequestBody User user) {

		return service.registerUser(user);

	}

}
