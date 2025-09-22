package com.tracecirclebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracecirclebackend.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String>{

	 @Query("SELECT MAX(e.employeeId) FROM EmployeeEntity e")
	 String findMaxId();
}
