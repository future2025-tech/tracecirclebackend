package com.tracecirclebackend.DTO;

import com.tracecirclebackend.constants.Status;
import com.tracecirclebackend.entity.OrganizationEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {

	private Long supplierId;
	
	private OrganizationEntity organizationId;
	
	private String supplierName;
	
	private String supplierLocation;
	
	private Status supplierstatus;
	
	private String supplierActions;
}
