package com.tracecirclebackend.entity;

import java.util.Locale.Category;

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

@Data
@AllArgsConstructor
@Entity
@Table(name="TC_RECYCLE")
public class RecycleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recycleId;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
	private OrganizationEntity organizationId;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "organization_name", nullable = false)
	private OrganizationEntity organizationName;
	
	private String recycleLocation;
	
	private Category recycleCategory;
	
	private Status recycleStatus;
	
	private String recycleAction;

}
