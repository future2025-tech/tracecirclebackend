package com.tracecirclebackend.DTO;

import com.tracecirclebackend.constants.ProductCategory;
import com.tracecirclebackend.constants.Status;
import com.tracecirclebackend.entity.OrganizationEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetailerDTO {

	private Long retailerId;
	
	private OrganizationEntity organizationId;
	
	private String retailerName;
	
	private String retailerLocation;
	
	private ProductCategory retailerCategory;
	
	private Status retailerStatus;
	
	private String retailerAction;
}
