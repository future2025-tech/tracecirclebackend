package com.tracecirclebackend.controller;

import org.springframework.web.bind.annotation.*;

import com.tracecirclebackend.entity.Organization;
import com.tracecirclebackend.service.OrganizationService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping
    public Organization createOrganization(@RequestBody Organization organization) {
        return service.saveOrganization(organization);
    }

    @GetMapping
    public List<Organization> getAllOrganizations() {
        return service.getAllOrganizations();
    }
    
    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable Long id) {
        return service.getOrganizationById(id);
    }

    @PutMapping("/{id}")
    public Organization updateOrganization(@PathVariable Long id, @RequestBody Organization organization) {
        return service.updateOrganization(id, organization);
    }
}
