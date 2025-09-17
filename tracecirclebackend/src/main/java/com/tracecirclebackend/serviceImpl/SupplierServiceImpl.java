package com.tracecirclebackend.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tracecirclebackend.DTO.SupplierDTO;
import com.tracecirclebackend.entity.SupplierEntity;
import com.tracecirclebackend.repository.SupplierRepository;
import com.tracecirclebackend.service.SupplierService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
	
	private final SupplierRepository supplierRepository;
	private final ModelMapper modelMapper;

	@Override
	public SupplierDTO saveSupplier(SupplierDTO supplier) {
		
		SupplierEntity entity = modelMapper.map(supplier, SupplierEntity.class);

        SupplierEntity savedEntity = supplierRepository.save(entity);

        return modelMapper.map(savedEntity, SupplierDTO.class);
	}

	@Override
	public List<SupplierDTO> getAllSuppliers() {
		return supplierRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, SupplierDTO.class))
                .toList();
	}

	@Override
	public SupplierDTO getSupplierById(Long id) {
		return supplierRepository.findById(id)
                .map(entity -> modelMapper.map(entity, SupplierDTO.class))
                .orElse(null);
	}

	@Override
	public SupplierDTO updateSupplier(Long id, SupplierDTO updatedSup) {
		 SupplierEntity entity = supplierRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException(
	                		"Supplier not found with ID: " + id));

	        entity.setSupplierName(updatedSup.getSupplierName());
	        entity.setSupplierLocation(updatedSup.getSupplierLocation());
	        entity.setSupplierStatus(updatedSup.getSupplierstatus());
	        entity.setSupplierActions(updatedSup.getSupplierActions());
	        SupplierEntity savedEntity = supplierRepository.save(entity);

	        return modelMapper.map(savedEntity, SupplierDTO.class);
	}

	@Override
	public SupplierDTO deleteSupplier(Long id) {
		
		SupplierEntity supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Supplier not found with id: " + id));

        SupplierDTO dto = modelMapper.map(supplier, SupplierDTO.class);
        supplierRepository.deleteById(id);
        
        return dto;
	}

}
