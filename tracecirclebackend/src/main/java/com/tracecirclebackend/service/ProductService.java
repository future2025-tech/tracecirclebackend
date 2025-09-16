package com.tracecirclebackend.service;

import java.util.List;

import com.tracecirclebackend.DTO.ProductDTO;

public interface ProductService {

	public ProductDTO saveProduct(ProductDTO product) ;

    public List<ProductDTO> getAllProducts();
    
    public ProductDTO getProductById(Long id);

    public ProductDTO updateProduct(Long id, ProductDTO updatedProd);
    
    public ProductDTO deleteProduct(Long id);
}
