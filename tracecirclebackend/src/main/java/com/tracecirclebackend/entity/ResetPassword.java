package com.tracecirclebackend.entity;

import lombok.Data;

@Data
public class ResetPassword {

	String email;
	
    String otp;
    
    String newPassword;
    
    String confirmPassword;
}
