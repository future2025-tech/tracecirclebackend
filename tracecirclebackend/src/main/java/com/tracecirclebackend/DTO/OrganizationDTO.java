package com.tracecirclebackend.DTO;


import com.tracecirclebackend.constants.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {
	
	private Long organizationId;

    private String organizationName;
    
    private Status organizationStatus;
    
    private String organizationLocation;

}
