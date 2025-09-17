package com.tracecirclebackend.DTO;

import com.tracecirclebackend.constants.Gender;
import com.tracecirclebackend.constants.Roles;
import com.tracecirclebackend.constants.Status;
import com.tracecirclebackend.entity.OrganizationEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
	private Long employeeId;

	private OrganizationEntity organizationId;   

    private Long departmentId;     
	    
    private String employeeName;
	    
    private Gender employeeGender;

    private Roles employeeRoles;

    private String employeeActions;

    private Status employeeStatus;
}
