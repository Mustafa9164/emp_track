package com.jsp.app.emp_track.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsp.app.emp_track.entity.OTP;
import com.jsp.app.emp_track.entity.User;
import com.jsp.app.emp_track.exception.InvalidCredential;
import com.jsp.app.emp_track.exception.InvalidOtpException;
import com.jsp.app.emp_track.repository.OtpRepo;
import com.jsp.app.emp_track.repository.UserRepo;
import com.jsp.app.emp_track.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private OtpRepo otpRepo;
	
	BCryptPasswordEncoder pass=new BCryptPasswordEncoder();
	
	@Override
	public User sigUp(User user) {
		user.setPassword(pass.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public String login(String value, String password) {
		User u1 = userRepo.login(value, value);
		if(u1 != null) {
			if(pass.matches(password, u1.getPassword())) {
				return sendOtp(u1.getEmail());
			}else {
				throw new InvalidCredential();
			}
		}else {
			throw new InvalidCredential();
		}
	}
	
	
	public String sendOtp(String email) {
		SimpleMailMessage mail=new SimpleMailMessage();
		int otp=(int)(Math.random()*10000000);
		mail.setFrom("mdrmustafa1234@gmail.com");
		mail.setTo(email);
		mail.setSubject("Otp for login");
		mail.setText("pls find the otp below \n Otp :"+otp+"\n please dont share with anyOne");
		javaMailSender.send(mail);
		return "OTP Send Through Email";



}
	@Override
	public User verifyOtp(int otp) {
	    OTP o1 = otpRepo.findByOtp(otp);
	    
	    if (o1 != null) {
	        // Assuming findById returns an Optional<User>
	        return userRepo.findById(o1.getUid()).orElseThrow(() -> new InvalidCredential());
	    } else {
	        // Throw the exception when OTP is not found
	        throw new InvalidOtpException("OTP not found");
	    }
	}

}
