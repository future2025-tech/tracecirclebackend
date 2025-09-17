package com.tracecirclebackend.DTO;

import com.tracecirclebackend.constants.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogisticsDTO {

	private Long logisticId;
	
	private OrganizationDTO organizationId;
	
	private String logisticName;
	
	private String logisticLocation;
	
	private Status logisticStatus;
	
	private String logisticAction;
}
