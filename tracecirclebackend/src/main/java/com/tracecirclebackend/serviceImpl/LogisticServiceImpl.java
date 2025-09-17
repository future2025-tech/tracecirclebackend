package com.tracecirclebackend.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tracecirclebackend.DTO.EmployeeDTO;
import com.tracecirclebackend.DTO.LogisticsDTO;
import com.tracecirclebackend.entity.EmployeeEntity;
import com.tracecirclebackend.entity.LogisticsEntity;
import com.tracecirclebackend.repository.LogisticRepository;
import com.tracecirclebackend.service.LogisticService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LogisticServiceImpl implements LogisticService {
	
	private final LogisticRepository logisticRepository;
	private final ModelMapper modelMapper;

	@Override
	public LogisticsDTO saveLogistic(LogisticsDTO logisticDTO) {
		
		LogisticsEntity entity = modelMapper.map(logisticDTO, LogisticsEntity.class);
	
		LogisticsEntity saveEntity = logisticRepository.save(entity);
		
		return modelMapper.map(saveEntity, LogisticsDTO.class);
	}

	@Override
	public LogisticsDTO getLogisticById(Long id) {
		
		return logisticRepository.findById(id)
                .map(entity -> modelMapper.map(entity, LogisticsDTO.class))
                .orElse(null);
		
	}

	@Override
	public List<LogisticsDTO> getAllLogistics() {
		
		return logisticRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, LogisticsDTO.class))
                .toList();
	}

	@Override
	public LogisticsDTO updateLogistic(Long id, LogisticsDTO dto) {
		LogisticsEntity existing = logisticRepository.findById(id)
		        .orElseThrow(() -> new IllegalArgumentException(
		        		"Logistic not found with id: " + id));

		    existing.setLogisticsName(dto.getLogisticName());
		    existing.setLogisticsLocation(dto.getLogisticLocation());
		    existing.setLogisticsStatus(dto.getLogisticStatus());
		    existing.setLogisticsActions(dto.getLogisticAction());

		    LogisticsEntity saved = logisticRepository.save(existing);
		    return modelMapper.map(saved, LogisticsDTO.class);
	}

	@Override
	public LogisticsDTO delateLogistic(Long id) {
		
		LogisticsEntity logistic = logisticRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(
						"Logistic not found by Id "+ id));
		
		LogisticsDTO dto = modelMapper.map(logistic, LogisticsDTO.class);
		
		logisticRepository.deleteById(id);
		
		return dto;
				
	}

}
