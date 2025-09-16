package com.tracecirclebackend.service;

import java.util.List;

import com.tracecirclebackend.DTO.DepartmentDTO;

public interface DepartmentService {

	public DepartmentDTO saveDepartment(DepartmentDTO department) ;

    public List<DepartmentDTO> getAllDepartments();
    
    public DepartmentDTO getDepartmentById(Long id);

    public DepartmentDTO updateDepartment(Long id, DepartmentDTO updatedDept);
    
    public DepartmentDTO deleteDepartment(Long id);
}
