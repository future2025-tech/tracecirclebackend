package com.tracecirclebackend.service;

public interface UserService {

	public void updatePassword(String email, String newPassword);
	
    public boolean isPasswordUsedBefore(String email, String newPassword);
    
    public void deleteUser(String email);
    
}
