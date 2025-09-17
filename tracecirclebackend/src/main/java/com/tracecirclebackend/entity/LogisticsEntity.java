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
@Table(name = "TC_LOGISTICS")
public class LogisticsEntity {

	@Id
	private Long logisticsId;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
	private OrganizationEntity organizationId;
	
	private String logisticsName;
	
	private String logisticsLocation;
	
    @Enumerated(EnumType.STRING)  
	private Status logisticsStatus;
	
	private String logisticsActions;
}
