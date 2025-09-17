package com.tracecirclebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TC_DEPARTMENTS")
public class DepartmentEntity {

    @Id
    private Long departmentId;

    private String departmentName;
    
    private String departmentActions;
    
    private String departmentOrganization;
    
    @Version
    private Long version;
}
