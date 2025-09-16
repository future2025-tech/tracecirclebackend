package com.tracecirclebackend.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tracecirclebackend.DTO.DepartmentDTO;
import com.tracecirclebackend.entity.DepartmentEntity;
import com.tracecirclebackend.repository.DepartmentRepository;
import com.tracecirclebackend.service.DepartmentService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	private final DepartmentRepository departmentRepository;
	private final ModelMapper modelMapper;
	
	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

		DepartmentEntity entity = modelMapper.map(departmentDTO, DepartmentEntity.class);

        DepartmentEntity savedEntity = departmentRepository.save(entity);

        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

	@Override
    public List<DepartmentDTO> getAllDepartments() {
    	
        return departmentRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, DepartmentDTO.class))
                .toList();
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
    	
        return departmentRepository.findById(id)
                .map(entity -> modelMapper.map(entity, DepartmentDTO.class))
                .orElse(null);
    }

    @Transactional
    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO updatedDept) {
    	
        DepartmentEntity entity = departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Department not found with ID: " + id));

        entity.setDepartmentName(updatedDept.getDepartmentName());
        entity.setDepartmentOrganization(updatedDept.getDepartmentOrganization());
        entity.setDepartmentActions(updatedDept.getDepartmentActions());

        DepartmentEntity savedEntity = departmentRepository.save(entity);

        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO deleteDepartment(Long id) {
        DepartmentEntity department = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Department not found with id: " + id));

        DepartmentDTO dto = modelMapper.map(department, DepartmentDTO.class);
        departmentRepository.deleteById(id);
        return dto;
    }
}
