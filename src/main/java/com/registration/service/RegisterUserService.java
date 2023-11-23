package com.registration.service;

import java.security.SecureRandom;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.registration.exceptionhandler.BusinessException;
import com.registration.model.RegisterDTO;
import com.registration.model.User;
import com.registration.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class RegisterUserService {

	@Autowired
	UserRepository repository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Transactional
	public RegisterDTO registerUser(User user) {

		boolean userNameInUse = repository.findByUserName(user.getUserName()).stream()
				.anyMatch(userExists -> !userExists.equals(user));

		boolean emailInUse = repository.findByUserEmail(user.getUserEmail()).stream()
				.anyMatch(userExists -> !userExists.equals(user));

		if (userNameInUse) {
			throw new BusinessException("Username already in use.");
		} else if (emailInUse) {
			throw new BusinessException("Email already in use.");
		}

		user.setUserSalt(genSalt());
		String password = user.getUserPassword() + user.getUserSalt();

		String encodedPassword = passwordEncoder.encode(password);

		user.setUserPassword(encodedPassword);

		repository.save(user);
		return new RegisterDTO(user);
	}

	private String genSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
		return encodedSalt;

	}
}
