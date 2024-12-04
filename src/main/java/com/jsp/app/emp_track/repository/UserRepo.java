package com.jsp.app.emp_track.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.app.emp_track.entity.User;

public interface UserRepo extends JpaRepository<User, String> {

	@Query("SELECT u FROM User u WHERE (u.userId = ?1 OR u.email = ?2)") 
	User login(String value1, String value2);


	
}
