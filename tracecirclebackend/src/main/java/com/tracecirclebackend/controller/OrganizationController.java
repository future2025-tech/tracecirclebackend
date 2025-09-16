package com.tracecirclebackend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracecirclebackend.DTO.OrganizationDTO;
import com.tracecirclebackend.serviceImpl.OrganizationServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationServiceImpl service;

    public OrganizationController(OrganizationServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public OrganizationDTO createOrganization(
    		@RequestBody OrganizationDTO organization) {
    	
        return service.saveOrganization(organization);
    }

    @GetMapping
    public List<OrganizationDTO> getAllOrganizations() {
    	
        return service.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public OrganizationDTO getOrganizationById(@PathVariable Long id) {
    	
        return service.getOrganizationById(id);
    }

    @PutMapping("/{id}")
    public OrganizationDTO updateOrganization(@PathVariable Long id,
    		@RequestBody OrganizationDTO organization) {
    	
        return service.updateOrganization(id, organization);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        OrganizationDTO deleted = service.deleteOrganization(id);

        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}
