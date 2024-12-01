package com.jsp.app.emp_track.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.app.emp_track.entity.User;
import com.jsp.app.emp_track.repository.UserRepo;
import com.jsp.app.emp_track.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User sigUp(User user) {
		return userRepo.save(user);
	}

}
