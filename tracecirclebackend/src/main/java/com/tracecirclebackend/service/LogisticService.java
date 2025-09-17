package com.tracecirclebackend.service;

import java.util.List;

import com.tracecirclebackend.DTO.LogisticsDTO;

public interface LogisticService {
	
	public LogisticsDTO saveLogistic(LogisticsDTO logisticDTO);
	
	public LogisticsDTO getLogisticById(Long id);
	
	public List<LogisticsDTO> getAllLogistics();
	
	public LogisticsDTO updateLogistic(Long id,LogisticsDTO logisticDTO);
	
	public LogisticsDTO delateLogistic(Long id);
}
