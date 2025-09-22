 package com.tracecirclebackend.entity;

import com.tracecirclebackend.constants.Gender;
import com.tracecirclebackend.constants.Roles;
import com.tracecirclebackend.constants.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TC_EMPLOYEE")
public class EmployeeEntity {

	@Id
    private String employeeId;

	@ManyToOne(optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
	private OrganizationEntity organizationId;   

    @Column(name = "department_id")
    private Long departmentId;     
    
    private String employeeName;
    
    @Enumerated(EnumType.STRING)
    private Gender employeeGender;

    @Enumerated(EnumType.STRING)
    private Roles employeeRoles;

    private String employeeActions;

    @Enumerated(EnumType.STRING)
    private Status employeeStatus;
    
}
