package com.jsp.app.emp_track.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.app.emp_track.entity.User;
import com.jsp.app.emp_track.serviceImpl.UserServiceImpl;

public interface UserService {
	
	
	User sigUp(User user);

	String login(String value, String password);
	
	User verifyOtp(int otp);

}
