package com.tracecirclebackend.service;

import java.util.List;

import com.tracecirclebackend.DTO.RetailerDTO;

public interface RetailerService {
	
	public RetailerDTO createRetailer(RetailerDTO retailerDTO);
	
	public List<RetailerDTO> getAllRetailers();
	
	public RetailerDTO getRetailerById(Long id);
	
	public RetailerDTO updateRetailerById(Long id, RetailerDTO retailerDTO);
	
	public RetailerDTO deleteRetailer(Long id);

}
