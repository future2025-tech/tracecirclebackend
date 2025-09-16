package com.tracecirclebackend.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tracecirclebackend.entity.UserEntity;
import com.tracecirclebackend.repository.UserRepository;
import com.tracecirclebackend.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity registerUser(String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email is already registered");
        }
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(password); // store plain text (not secure)
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> loginUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password));
    }

    @Override
    public boolean updatePassword(String email, String newPassword) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    user.setPassword(newPassword); // store plain text
                    userRepository.save(user);
                    return true;
                }).orElse(false);
    }
}
