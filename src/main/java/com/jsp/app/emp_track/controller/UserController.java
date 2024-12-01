package com.jsp.app.emp_track.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.app.emp_track.entity.User;
import com.jsp.app.emp_track.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/signUp")
	public ResponseEntity<User> sinUp(@RequestBody User user){
		return new ResponseEntity<User>(userService.sigUp(user),HttpStatus.CREATED);
	}

}
