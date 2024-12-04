package com.jsp.app.emp_track.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.app.emp_track.entity.User;
import com.jsp.app.emp_track.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signUp")
	public ResponseEntity<User> sinUp(@RequestBody User user){
		return new ResponseEntity<User>(userService.sigUp(user),HttpStatus.CREATED);
	}
    
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String value, @RequestParam String password){
    	return new ResponseEntity<String>(userService.login(value, password) ,HttpStatus.OK);
    }
    
    @GetMapping("/verify")
    public ResponseEntity<User> verifyOtp(@RequestParam int otp){
    	return new ResponseEntity<User>(userService.verifyOtp(otp),HttpStatus.ACCEPTED);
    }

}
