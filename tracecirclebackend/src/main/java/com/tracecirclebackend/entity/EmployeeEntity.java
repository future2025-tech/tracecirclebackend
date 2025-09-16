package com.tracecirclebackend.entity;

import com.tracecirclebackend.constants.Gender;
import com.tracecirclebackend.constants.Roles;
import com.tracecirclebackend.constants.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TC_EMPLOYEE")
public class EmployeeEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "organization_id")
    private Long organizationId;   

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
