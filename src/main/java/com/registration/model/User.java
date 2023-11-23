package com.registration.model;

import com.registration.customvalidator.NotBlankOrNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users_table")
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "user_name")
	@NotBlankOrNull
	private String userName;

	@Column(name = "user_email")
	@NotBlankOrNull
	private String userEmail;

	@Column(name = "user_password")
	@NotBlankOrNull
	private String userPassword;

	@Column(name = "user_salt")
	private String userSalt;

	@Column(name = "user_role")
	private final String userRole = "USER";

	public User(String userName, String userEmail, String userPassword) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

}
