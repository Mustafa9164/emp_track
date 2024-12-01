package com.jsp.app.emp_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.app.emp_track.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
