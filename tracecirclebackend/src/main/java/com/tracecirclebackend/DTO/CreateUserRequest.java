package com.tracecirclebackend.DTO;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private String password;
}
