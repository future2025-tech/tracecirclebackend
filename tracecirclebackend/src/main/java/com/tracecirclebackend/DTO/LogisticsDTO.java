package com.tracecirclebackend.DTO;

import com.tracecirclebackend.constants.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogisticsDTO {

	private Long logisticsId;
	
	private OrganizationDTO organizationId;
	
	private String logisticsName;
	
	private String logisticsLocation;
	
	private Status logisticsStatus;
	
	private String logisticsActions;
}
