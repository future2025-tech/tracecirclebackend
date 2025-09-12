package com.tracecirclebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracecirclebackend.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
