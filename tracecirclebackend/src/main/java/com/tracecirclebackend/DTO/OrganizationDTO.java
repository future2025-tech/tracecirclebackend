package com.tracecirclebackend.DTO;

import java.io.ObjectInputFilter.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {
	
	private Long orianizationId;

    private String organizationName;
    
    private Status organizationStatus;
    
    private String organizationLocation;

}
