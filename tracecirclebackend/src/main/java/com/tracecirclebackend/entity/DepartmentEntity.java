package com.tracecirclebackend.entity;

import jakarta.persistence.*;
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
