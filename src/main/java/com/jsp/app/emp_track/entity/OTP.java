package com.jsp.app.emp_track.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class OTP {
	
	@Id
	private String uid;
	private int otp;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public OTP(String uid, int otp) {
		super();
		this.uid = uid;
		this.otp = otp;
	}
	public OTP() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	

}
