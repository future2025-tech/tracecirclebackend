package com.tracecirclebackend.service;

import java.util.List;

import com.tracecirclebackend.DTO.RecycleDTO;

public interface RecycleService {

	public RecycleDTO createRecycle(RecycleDTO recycleDTO);
	
	public List<RecycleDTO> getAllRecycles();
	
	public RecycleDTO getRecycleById(Long id);
	
	public RecycleDTO updateRecycleById(Long id, RecycleDTO recycleDTO);
	
	public RecycleDTO deleteRecycleById(Long id);
}
