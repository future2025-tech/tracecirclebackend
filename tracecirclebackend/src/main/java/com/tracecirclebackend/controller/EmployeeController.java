package com.tracecirclebackend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracecirclebackend.DTO.EmployeeDTO;
import com.tracecirclebackend.serviceImpl.EmployeeServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("employee")
@AllArgsConstructor
public class EmployeeController {

private final EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO empDto) {
		
		return employeeServiceImpl.saveEmployee(empDto);
	}
	
	@GetMapping
	public List<EmployeeDTO> getAllEmployees(){
		
		 return employeeServiceImpl.getAllEmployes();
	}
	
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable long id) {
		
		return employeeServiceImpl.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public EmployeeDTO updateEmployeeDTO(@PathVariable long id,
			@RequestBody EmployeeDTO employeeDTO) {
		
		return employeeServiceImpl.updateEmployee(id, employeeDTO);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        EmployeeDTO deleted = employeeServiceImpl.deleteEmployee(id);

        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }

}
