package com.tracecirclebackend.service;

import java.util.List;

import com.tracecirclebackend.DTO.EmployeeDTO;

public interface EmployeeService {
	
	public EmployeeDTO createEmployee(EmployeeDTO employee) ;

    public List<EmployeeDTO> getAllEmployes();
    
    public EmployeeDTO getEmployeeById(String id);

    public EmployeeDTO updateEmployee(String id, EmployeeDTO updatedEmp);
    
    public EmployeeDTO deleteEmployee(String id);
    
    public String findMaxId();
}
