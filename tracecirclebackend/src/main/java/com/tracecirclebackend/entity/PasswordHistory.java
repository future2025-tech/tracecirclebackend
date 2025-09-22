package com.tracecirclebackend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordHistory {
    
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String email;
    
	private String password; // hashed
    
	private LocalDateTime changedAt;
}
