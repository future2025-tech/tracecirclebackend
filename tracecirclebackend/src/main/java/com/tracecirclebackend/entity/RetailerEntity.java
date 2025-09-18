package com.tracecirclebackend.entity;

import com.tracecirclebackend.constants.ProductCategory;
import com.tracecirclebackend.constants.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="TC_RETAIL")
public class RetailerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long retailerId;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
	private OrganizationEntity organizationId;
	
	private String retailerName;
	
	private String retailerLocation;
	
	private ProductCategory retailerCategory;
	
	private Status retailerStatus;
	
	private String retailerAction;
}
