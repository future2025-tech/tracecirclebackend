package com.tracecirclebackend.service;

import java.util.List;

import com.tracecirclebackend.DTO.EmployeeDTO;

public interface EmployeeService {
	
	public EmployeeDTO saveEmployee(EmployeeDTO employee) ;

    public List<EmployeeDTO> getAllEmployes();
    
    public EmployeeDTO getEmployeeById(Long id);

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmp);
    
    public EmployeeDTO deleteEmployee(Long id);
    

}
