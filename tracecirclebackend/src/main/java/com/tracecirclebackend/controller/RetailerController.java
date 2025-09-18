package com.tracecirclebackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracecirclebackend.DTO.RetailerDTO;
import com.tracecirclebackend.serviceImpl.RetailerServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/retailer")
@AllArgsConstructor
public class RetailerController {

	private RetailerServiceImpl retailerServiceImpl;
	
	@PostMapping
	public RetailerDTO createRetailer(@RequestBody RetailerDTO retailerDTO) {
		
		return retailerServiceImpl.createRetailer(retailerDTO);
	}
	
	@GetMapping
	public List<RetailerDTO> getAllRetailers(){
		
		return retailerServiceImpl.getAllRetailers();
	}
	
	@GetMapping("/{id}")
	public RetailerDTO getRetailersByID(@PathVariable Long id){
		
		return retailerServiceImpl.getRetailerById(id);
	}
	
	@PutMapping("/{id}")
	public RetailerDTO updateRetailer(@PathVariable Long id, 
			@RequestBody RetailerDTO retailerDTO) {
		
	    return retailerServiceImpl.updateRetailerById(id, retailerDTO);
	}
	
	@DeleteMapping("/{id}")
	public RetailerDTO deleteRetailerById(@PathVariable Long id) {
		
		return retailerServiceImpl.deleteRetailer(id);
	}
}
