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

import com.tracecirclebackend.DTO.DepartmentDTO;
import com.tracecirclebackend.serviceImpl.DepartmentServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
	
	private final DepartmentServiceImpl departmentServiceImpl;
	
	@PostMapping
	public DepartmentDTO createDepartment(@RequestBody DepartmentDTO deptDto) {
		
		return departmentServiceImpl.saveDepartment(deptDto);
	}
	
	@GetMapping
	public List<DepartmentDTO> getAllDepartments(){
		
		 return departmentServiceImpl.getAllDepartments();
	}
	
	@GetMapping("/{id}")
	public DepartmentDTO getDepartmentById(@PathVariable long id) {
		
		return departmentServiceImpl.getDepartmentById(id);
	}
	
	@PutMapping("/{id}")
	public DepartmentDTO updateDepartmentDTO(@PathVariable long id,
			@RequestBody DepartmentDTO departmentDTO) {
		
		return departmentServiceImpl.updateDepartment(id, departmentDTO);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<DepartmentDTO> deleteDepartment(@PathVariable Long id) {
        DepartmentDTO deleted = departmentServiceImpl.deleteDepartment(id);

        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }

}
