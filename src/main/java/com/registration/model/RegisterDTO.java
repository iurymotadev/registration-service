package com.registration.model;

public record RegisterDTO(String userName, String userEmail) {

	public RegisterDTO(User user) {
		this(user.getUserName(), user.getUserEmail());
	}

}
