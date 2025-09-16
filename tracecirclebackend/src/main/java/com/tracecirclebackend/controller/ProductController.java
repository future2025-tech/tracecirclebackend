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

import com.tracecirclebackend.DTO.ProductDTO;
import com.tracecirclebackend.serviceImpl.ProductServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

private final ProductServiceImpl productServiceImpl;
	
	@PostMapping
	public ProductDTO createProduct(@RequestBody ProductDTO prodDto) {
		
		return productServiceImpl.saveProduct(prodDto);
	}
	
	@GetMapping
	public List<ProductDTO> getAllDepartments(){
		
		 return productServiceImpl.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		
		return productServiceImpl.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public ProductDTO updateProductDTO(@PathVariable Long id,
			@RequestBody ProductDTO productDTO) {
		
		return productServiceImpl.updateProduct(id, productDTO);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> deleteProductDTO(@PathVariable Long id) {
        ProductDTO deletedProduct = productServiceImpl.deleteProduct(id);
        return ResponseEntity.ok(deletedProduct);
    }

}
