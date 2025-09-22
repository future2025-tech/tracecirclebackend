package com.tracecirclebackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracecirclebackend.DTO.CreateUserRequest;
import com.tracecirclebackend.DTO.EmailRequest;
import com.tracecirclebackend.entity.ResetPassword;
import com.tracecirclebackend.entity.UserEntity;
import com.tracecirclebackend.repository.UserRepository;
import com.tracecirclebackend.serviceImpl.EmailServiceImpl;
import com.tracecirclebackend.serviceImpl.OtpServiceImpl;
import com.tracecirclebackend.serviceImpl.UserServiceImpl;
import com.tracecirclebackend.util.PasswordValidator;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final OtpServiceImpl otpService;
    private final EmailServiceImpl emailService;
    private final UserServiceImpl userService;
    private final UserRepository userRepo;
   

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest req) {
        try {
            UserEntity user = userService.createUser(req.getEmail(), req.getPassword());
            try {
                emailService.sendWelcomeEmail(user.getEmail(), req.getPassword());
            } catch (Exception e) {
                System.err.println("Email send failed: " + e.getMessage());
            }
            return ResponseEntity.ok("User created successfully.");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Create user failed: "
        + ex.getMessage());
        }
    }


    @PostMapping("/forgot-password")
    public String requestOtp(@RequestBody EmailRequest emailRequest) {
        String email = emailRequest.getEmail();

        String otp = otpService.generateOtp(email);
        emailService.sendOtpEmail(email, otp);

        return "OTP sent to email";
    }


    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody ResetPassword resetPassword) {

        if (!resetPassword.getNewPassword().equals(resetPassword.getConfirmPassword()))
            return "Passwords do not match";

        if (!PasswordValidator.isValid(resetPassword.getNewPassword()))
            return "Password must contain 8+ chars, uppercase, "
            		+ "lowercase, number, special char";

        if (!otpService.validateOtp(resetPassword.getEmail(), resetPassword.getOtp()))
            return "Invalid or expired OTP";

        if (userService.isPasswordUsedBefore(resetPassword.getEmail(), 
        		resetPassword.getNewPassword()))
            return "Cannot reuse previous password";

        userService.updatePassword(resetPassword.getEmail(), 
        		resetPassword.getNewPassword());
        
        emailService.sendPasswordChangedEmail(resetPassword.getEmail());

        return "Password updated successfully";
    }
    
    @DeleteMapping("/delete-account")
    public String deleteAccount(@RequestBody EmailRequest emailRequest) {
    	
        if (userRepo.findByEmail(emailRequest.getEmail()) == null) {
            return "User not found";
        }

        userService.deleteUser(emailRequest.getEmail());
        emailService.sendAccountDeletedEmail(emailRequest.getEmail());

        return "User account deleted successfully";
    }

}
