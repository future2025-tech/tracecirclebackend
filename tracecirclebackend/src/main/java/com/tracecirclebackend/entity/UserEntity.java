package com.tracecirclebackend.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TC_USERS")
public class UserEntity {

	@Id
	@GeneratedValue(generator = "user-id-generator")
	@GenericGenerator(
	    name = "user-id-generator",
	    strategy = "com.tracecirclebackend.util.UserIdGenerator"
	)
	private String id;
	

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;
    
}

