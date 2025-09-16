package com.tracecirclebackend.service;

import java.util.List;

import com.tracecirclebackend.DTO.OrganizationDTO;

public interface OrganizationService {
	
	public OrganizationDTO saveOrganization(OrganizationDTO organization);
	
	public List<OrganizationDTO> getAllOrganizations();
	
	public OrganizationDTO getOrganizationById(Long id);
	
	public OrganizationDTO updateOrganization(Long id, OrganizationDTO updatedOrg);
	
	public OrganizationDTO deleteOrganization(Long id);

}
