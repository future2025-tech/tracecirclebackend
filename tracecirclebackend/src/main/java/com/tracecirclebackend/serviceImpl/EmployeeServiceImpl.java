package com.tracecirclebackend.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tracecirclebackend.DTO.EmployeeDTO;
import com.tracecirclebackend.entity.EmployeeEntity;
import com.tracecirclebackend.repository.EmployeeRepository;
import com.tracecirclebackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employee) {
		 EmployeeEntity entity = modelMapper.map(employee, EmployeeEntity.class);

	        // Generate custom ID
	        String maxId = employeeRepository.findMaxId();
	        int nextNum = (maxId == null) ? 1 : Integer.parseInt(maxId.substring(4)) + 1;
	        entity.setEmployeeId(String.format("EMP-%04d", nextNum));

	        EmployeeEntity saved = employeeRepository.save(entity);
	        return modelMapper.map(saved, EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> getAllEmployes() {
		return employeeRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, EmployeeDTO.class))
                .toList();
	}

	@Override
	public EmployeeDTO getEmployeeById(String id) {
		return employeeRepository.findById(id)
                .map(entity -> modelMapper.map(entity, EmployeeDTO.class))
                .orElse(null);
	}

	@Override
	public EmployeeDTO updateEmployee(String id, EmployeeDTO dto) {
	    EmployeeEntity existing = employeeRepository.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException(
	        		"Employee not found with id: " + id));

	    existing.setEmployeeName(dto.getEmployeeName());
	    existing.setDepartmentId(dto.getDepartmentId());
	    existing.setEmployeeGender(dto.getEmployeeGender());
	    existing.setEmployeeRoles(dto.getEmployeeRoles());
	    existing.setEmployeeActions(dto.getEmployeeActions());
	    existing.setEmployeeStatus(dto.getEmployeeStatus());

	    EmployeeEntity saved = employeeRepository.save(existing);
	    return modelMapper.map(saved, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO deleteEmployee(String id) {
		
		EmployeeEntity department = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Employee not found with id: " + id));

        EmployeeDTO dto = modelMapper.map(department, EmployeeDTO.class);
        employeeRepository.deleteById(id);
        
        return dto;
	}

	@Override
	public String findMaxId() {
		// TODO Auto-generated method stub
		return null;
	}
}
