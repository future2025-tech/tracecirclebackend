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

import com.tracecirclebackend.DTO.LogisticsDTO;
import com.tracecirclebackend.serviceImpl.LogisticServiceImpl;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("logistics")
@AllArgsConstructor
@Table(name="TC_LOGISTICS")
public class LogisticController {
	
	private final LogisticServiceImpl logisticServiceImpl;
	
	@PostMapping
	public LogisticsDTO createLogistic(@RequestBody LogisticsDTO logisticDTO) {
		
		return logisticServiceImpl.saveLogistic(logisticDTO);
	}
	
	@GetMapping
	public List<LogisticsDTO> getLogistics() {
		
		return logisticServiceImpl.getAllLogistics();
	}
	
	@GetMapping("{/id}")
	public LogisticsDTO getLogisticsById(@PathVariable Long id) {
		
		return logisticServiceImpl.getLogisticById(id);
	}
	
	@PutMapping
	public LogisticsDTO updateLogistic(@PathVariable Long id,
			@RequestBody LogisticsDTO logisticsDTO) {
		
		return logisticServiceImpl.updateLogistic(id, logisticsDTO);
	}
	
	@DeleteMapping
	public LogisticsDTO deleteLogistic(@PathVariable Long id) {
		
		return logisticServiceImpl.delateLogistic(id);
		
	}

}
