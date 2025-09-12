package com.tracecirclebackend.service;

import com.tracecirclebackend.entity.User;
import com.tracecirclebackend.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Hashing function (SHA-256)
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString(); // looks unreadable, secure
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public User registerUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(hashPassword(password));
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String email, String password) {
        String hashed = hashPassword(password);
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(hashed));
    }
    
    @Transactional
    public boolean updatePassword(String email, String newPassword) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(hashPassword(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}

