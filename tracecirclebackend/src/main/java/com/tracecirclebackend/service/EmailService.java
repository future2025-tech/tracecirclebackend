package com.tracecirclebackend.service;

public interface EmailService {
	
	public void sendWelcomeEmail(String sendTo, String tempPassword);
	
    public void sendOtpEmail(String sendTo, String otp);
    
    public void sendPasswordChangedEmail(String sendTo);

}
