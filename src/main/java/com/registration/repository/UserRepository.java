package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.model.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByUserName(String userName);

	public List<User> findByUserEmail(String userEmail);

}
