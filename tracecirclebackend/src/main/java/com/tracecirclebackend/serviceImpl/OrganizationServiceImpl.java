package com.tracecirclebackend.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tracecirclebackend.DTO.OrganizationDTO;
import com.tracecirclebackend.entity.OrganizationEntity;
import com.tracecirclebackend.repository.OrganizationRepository;
import com.tracecirclebackend.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organization) {

    	OrganizationEntity entity = modelMapper.map(organization, OrganizationEntity.class);

        OrganizationEntity savedEntity = repository.save(entity);

        return modelMapper.map(savedEntity, OrganizationDTO.class);
    }

    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        return repository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, OrganizationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationDTO getOrganizationById(Long id) {
        
    	return repository.findById(id)
                .map(entity -> modelMapper.map(entity, OrganizationDTO.class))
                .orElse(null);
    }

    @Override
    public OrganizationDTO updateOrganization(Long id, OrganizationDTO updatedOrg) {
        
    	return repository.findById(id)
                .map(existingEntity -> {
                    modelMapper.map(updatedOrg, existingEntity);

                    OrganizationEntity savedEntity = repository.save(existingEntity);

                    return modelMapper.map(savedEntity, OrganizationDTO.class);
                })
                .orElse(null);
    }

	@Override
	public OrganizationDTO deleteOrganization(Long id) {
		
		OrganizationEntity department = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Organization not found with id: " + id));

        OrganizationDTO dto = modelMapper.map(department, OrganizationDTO.class);
        repository.deleteById(id);
        
        return dto;
	}
}
