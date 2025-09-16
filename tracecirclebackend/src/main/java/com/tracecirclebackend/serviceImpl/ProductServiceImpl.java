package com.tracecirclebackend.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tracecirclebackend.DTO.ProductDTO;
import com.tracecirclebackend.entity.ProductEntity;
import com.tracecirclebackend.repository.ProductRepository;
import com.tracecirclebackend.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	

	@Override
	public ProductDTO saveProduct(ProductDTO product) {
		
		ProductEntity entity = modelMapper.map(product, ProductEntity.class);
		
		ProductEntity saveEntity = productRepository.save(entity);
		
		return modelMapper.map(saveEntity, ProductDTO.class);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		
		return productRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class))
                .toList();
	}

	@Override
	public ProductDTO getProductById(Long id) {
		
		return productRepository.findById(id)
                .map(entity -> modelMapper.map(entity, ProductDTO.class))
                .orElse(null);
	}

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO updatedProd) {
		
		ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                		"Product not found with ID: " + id));

		entity.setOrganizationId(updatedProd.getOrganizationId());
        entity.setProductName(updatedProd.getProductName());
        entity.setProductCategory(updatedProd.getProductCategory());
        entity.setCompliance(updatedProd.getCompliance());
        entity.setProductStatus(updatedProd.getProductStatus());
        entity.setProductActions(updatedProd.getProductActions());

        ProductEntity savedEntity = productRepository.save(entity);

        return modelMapper.map(savedEntity, ProductDTO.class);
	}

	@Override
	public ProductDTO deleteProduct(Long id) {
		ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Product not found with id: " + id));

        ProductDTO dto = modelMapper.map(product, ProductDTO.class);
        productRepository.deleteById(id);
        return dto;
	}

}
