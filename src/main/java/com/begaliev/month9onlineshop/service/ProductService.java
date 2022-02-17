package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.dto.ProductDTO;
import com.begaliev.month9onlineshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductDTO> getAll(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductDTO::from);
    }

    public ProductDTO getById(Integer id) {
        return ProductDTO.from(productRepository.findById(id).get());
    }

    public Page<ProductDTO> getAllByTypeId(int id, Pageable pageable) {
        return productRepository.findAllByTypeId(id, pageable).map(ProductDTO::from);
    }

    public Page<ProductDTO> search(String name, String description, Pageable pageable) {
        return productRepository.findAllByNameContainingOrDescriptionContaining(name, description, pageable)
                .map(ProductDTO::from);
    }
}
