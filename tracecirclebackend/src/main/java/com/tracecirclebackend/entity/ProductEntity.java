package com.tracecirclebackend.entity;

import com.tracecirclebackend.constants.Compliance;
import com.tracecirclebackend.constants.ProductCategory;
import com.tracecirclebackend.constants.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TC_PRODUCTS")
public class ProductEntity {
	
	@Id
	private Long productId;
	
	private Long organizationId;
	
	private String ProductName;
	
	private ProductCategory productCategory;
	
	private Compliance compliance;
	
	private Status productStatus;
	
	private String productActions;

}
