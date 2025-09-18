package com.tracecirclebackend.DTO;

import java.util.Locale.Category;

import com.tracecirclebackend.constants.Status;
import com.tracecirclebackend.entity.OrganizationEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecycleDTO {

	private Long recycleId;
	
	private OrganizationEntity organizationId;
	
	private OrganizationEntity organizationName;
	
	private String recycleLocation;
	
	private Category recycleCategory;
	
	private Status recycleStatus;
	
	private String recycleAction;

}
