package com.tracecirclebackend.service;


import org.springframework.stereotype.Service;

import com.tracecirclebackend.entity.Organization;
import com.tracecirclebackend.repository.OrganizationRepository;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository repository;

    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public Organization saveOrganization(Organization organization) {
        return repository.save(organization);
    }

    public List<Organization> getAllOrganizations() {
        return repository.findAll();
    }
    
    public Organization getOrganizationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    
    public Organization updateOrganization(Long id, Organization updatedOrg) {
        return repository.findById(id).map(org -> {
            org.setName(updatedOrg.getName());
            org.setAddress(updatedOrg.getAddress());
            org.setLocation(updatedOrg.getLocation());
            return repository.save(org);
        }).orElse(null);
    }
}
