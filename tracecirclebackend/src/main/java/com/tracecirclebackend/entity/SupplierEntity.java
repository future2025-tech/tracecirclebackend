package com.tracecirclebackend.entity;

import com.tracecirclebackend.constants.Status;

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
@Table(name = "TC_SUPPLIERS")
public class SupplierEntity {

	@Id
	private Long supplierId;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
	private OrganizationEntity organizationId;
	
	private String supplierName;
	
	private String supplierLocation;
	
    @Enumerated(EnumType.STRING)  
	private Status supplierStatus;
	
	private String supplierActions;
	
}
