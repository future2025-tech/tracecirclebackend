package com.tracecirclebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracecirclebackend.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	UserEntity findByEmail(String email);
	}
