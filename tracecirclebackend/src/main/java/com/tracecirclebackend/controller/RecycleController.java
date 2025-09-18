package com.tracecirclebackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracecirclebackend.DTO.RecycleDTO;
import com.tracecirclebackend.serviceImpl.RecycleServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/recycle")
@AllArgsConstructor
public class RecycleController {

	private final RecycleServiceImpl recycleServiceImpl;
	
	@PostMapping
	public RecycleDTO createRecycle(@RequestBody RecycleDTO recycleDTO) {
		
		return recycleServiceImpl.createRecycle(recycleDTO);
	}
	
	@GetMapping
	public List<RecycleDTO> getAllRecycles(){
		
		return recycleServiceImpl.getAllRecycles();
	}
	
	@GetMapping("/{id}")
	public RecycleDTO getRecycleById(@PathVariable Long id) {
		
		return recycleServiceImpl.getRecycleById(id);
	}
	
	@PutMapping("/{id}")
	public RecycleDTO updateRecycle(@PathVariable Long id,
			@RequestBody RecycleDTO recycleDTO) {
		
		return recycleServiceImpl.updateRecycleById(id, recycleDTO);
	}
	
	@DeleteMapping
	public RecycleDTO deleteRecycle(@PathVariable Long id) {
		
		return recycleServiceImpl.deleteRecycleById(id);
	}
	
}
