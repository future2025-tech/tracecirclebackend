package com.tracecirclebackend.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tracecirclebackend.DTO.RetailerDTO;
import com.tracecirclebackend.entity.RetailerEntity;
import com.tracecirclebackend.repository.RetailerRepository;
import com.tracecirclebackend.service.RetailerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetailerServiceImpl implements RetailerService {
	
	private final RetailerRepository retailerRepository;
	private final ModelMapper modelMapper;

	@Override
	public RetailerDTO createRetailer(RetailerDTO retailerDTO) {
		
		RetailerEntity entity = modelMapper.map(retailerDTO, RetailerEntity.class);
		
		RetailerEntity saveEntity = retailerRepository.save(entity);
		
		return modelMapper.map(saveEntity, RetailerDTO.class);
	}

	@Override
	public List<RetailerDTO> getAllRetailers() {
		
		return retailerRepository.findAll().stream()
	            .map(entity -> modelMapper.map(entity, RetailerDTO.class)).toList();
	}

	@Override
	public RetailerDTO getRetailerById(Long id) {
		
		return retailerRepository.findById(id)
	            .map(entity -> modelMapper.map(entity, RetailerDTO.class))
	            .orElse(null);
	}

	@Override
	public RetailerDTO updateRetailerById(Long id, RetailerDTO updatedRetailer) {

	    RetailerEntity entity = retailerRepository.findById(id)
	            .orElseThrow(() -> new NoSuchElementException(
	                    "Retailer not found with ID: " + id));

	    entity.setRetailerName(updatedRetailer.getRetailerName());
	    entity.setRetailerLocation(updatedRetailer.getRetailerLocation());
	    entity.setRetailerStatus(updatedRetailer.getRetailerStatus());
	    entity.setOrganizationId(updatedRetailer.getOrganizationId());
	    entity.setRetailerCategory(updatedRetailer.getRetailerCategory());
	    entity.setRetailerAction(updatedRetailer.getRetailerAction());

	    RetailerEntity savedEntity = retailerRepository.save(entity);
	    return modelMapper.map(savedEntity, RetailerDTO.class);
	}


	@Override
	public RetailerDTO deleteRetailer(Long id) {
		
		RetailerEntity retailer = retailerRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException(
	            		"Retailer not found with id: " + id));

	        RetailerDTO dto = modelMapper.map(retailer, RetailerDTO.class);
	        retailerRepository.deleteById(id);
	        return dto;
	}

}
