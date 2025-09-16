package com.tracecirclebackend.DTO;

import com.tracecirclebackend.constants.Compliance;
import com.tracecirclebackend.constants.ProductCategory;
import com.tracecirclebackend.constants.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

private Long productId;
	
	private Long organizationId;
	
	private String ProductName;
	
	private ProductCategory productCategory;
	
	private Compliance compliance;
	
	private Status productStatus;
	
	private String productActions;
}
