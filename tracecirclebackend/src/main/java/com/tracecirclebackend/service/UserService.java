package com.tracecirclebackend.service;

import com.tracecirclebackend.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    UserEntity registerUser(String email, String password);

    Optional<UserEntity> loginUser(String email, String password);

    boolean updatePassword(String email, String newPassword);
}
