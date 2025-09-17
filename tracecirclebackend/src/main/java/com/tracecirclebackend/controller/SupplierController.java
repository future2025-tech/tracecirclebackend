package com.tracecirclebackend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracecirclebackend.DTO.SupplierDTO;
import com.tracecirclebackend.serviceImpl.SupplierServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/suppliers")
public class SupplierController {

	private final SupplierServiceImpl supplierServiceImpl;
		
	@PostMapping
	public SupplierDTO createSupplier(@RequestBody SupplierDTO supDto) {
		
		return supplierServiceImpl.saveSupplier(supDto);
	}
	
	@GetMapping
	public List<SupplierDTO> getAllSuppliers(){
		
		 return supplierServiceImpl.getAllSuppliers();
	}
	
	@GetMapping("/{id}")
	public SupplierDTO getSupplierById(@PathVariable long id) {
		
		return supplierServiceImpl.getSupplierById(id);
	}
	
	@PutMapping("/{id}")
	public SupplierDTO updateSupplierDTO(@PathVariable long id,
			@RequestBody SupplierDTO supplierDTO) {
		
		return supplierServiceImpl.updateSupplier(id, supplierDTO);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        SupplierDTO deleted = supplierServiceImpl.deleteSupplier(id);

        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}
