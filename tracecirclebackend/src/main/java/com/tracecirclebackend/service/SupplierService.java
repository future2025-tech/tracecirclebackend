package com.tracecirclebackend.service;

import java.util.List;

import com.tracecirclebackend.DTO.SupplierDTO;

public interface SupplierService {

	public SupplierDTO saveSupplier(SupplierDTO supplier) ;

    public List<SupplierDTO> getAllSuppliers();
    
    public SupplierDTO getSupplierById(Long id);

    public SupplierDTO updateSupplier(Long id, SupplierDTO updatedSup);
    
    public SupplierDTO deleteSupplier(Long id);
}
