package com.tracecirclebackend.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tracecirclebackend.DTO.RecycleDTO;
import com.tracecirclebackend.entity.RecycleEntity;
import com.tracecirclebackend.repository.RecycleRepository;
import com.tracecirclebackend.service.RecycleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecycleServiceImpl implements RecycleService {

	private final RecycleRepository recycleRepository;
	private final ModelMapper modelMapper;
	
	@Override
	public RecycleDTO createRecycle(RecycleDTO recycleDTO) {
		
		RecycleEntity entity = modelMapper.map(recycleDTO, RecycleEntity.class);
		
		RecycleEntity saveRecycle = recycleRepository.save(entity);
		
		return modelMapper.map(saveRecycle, RecycleDTO.class);
	}

	@Override
	public List<RecycleDTO> getAllRecycles() {
		
		return recycleRepository.findAll().stream().map(
				entity -> modelMapper.map(entity, RecycleDTO.class)).toList();
	}

	@Override
	public RecycleDTO getRecycleById(Long id) {
		return recycleRepository.findById(id).map(
				entity -> modelMapper.map(entity, RecycleDTO.class))
				.orElseThrow(null);
	}

	@Override
	public RecycleDTO updateRecycleById(Long id, RecycleDTO recycleDTO) {
		 RecycleEntity entity = recycleRepository.findById(id)
		            .orElseThrow(() -> new NoSuchElementException(
		            		"Recycle not found with ID: " + id));

		        entity.setOrganizationName(recycleDTO.getOrganizationName());
		        entity.setRecycleAction(recycleDTO.getRecycleAction());
		        entity.setRecycleCategory(recycleDTO.getRecycleCategory());
		        entity.setRecycleLocation(recycleDTO.getRecycleLocation());
		        entity.setRecycleStatus(recycleDTO.getRecycleStatus());

		        RecycleEntity savedEntity = recycleRepository.save(entity);
		        return modelMapper.map(savedEntity, RecycleDTO.class);
	}

	@Override
	public RecycleDTO deleteRecycleById(Long id) {

		RecycleEntity recycle = recycleRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException(
	            		"Recycle not found with id: " + id));

	        RecycleDTO dto = modelMapper.map(recycle , RecycleDTO.class);
	        recycleRepository.deleteById(id);
	        
	        return dto;
	}

}
