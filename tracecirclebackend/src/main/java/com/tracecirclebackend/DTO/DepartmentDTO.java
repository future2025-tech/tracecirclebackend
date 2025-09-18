package com.tracecirclebackend.DTO;

import com.tracecirclebackend.entity.OrganizationEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
	
	private Long departmentId;

    private String departmentName;
    
    private String departmentActions;
    
    private OrganizationEntity departmentOrganization; 

}
