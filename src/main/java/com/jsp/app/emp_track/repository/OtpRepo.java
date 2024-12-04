package com.jsp.app.emp_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.app.emp_track.entity.OTP;

public interface OtpRepo extends JpaRepository<OTP, String>{

	OTP findByOtp(int otp);
}
