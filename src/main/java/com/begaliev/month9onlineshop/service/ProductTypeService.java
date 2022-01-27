package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.dto.ProductTypeDTO;
import com.begaliev.month9onlineshop.repository.ProductTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public Page<ProductTypeDTO> getAll(Pageable pageable){
        return productTypeRepository.findAll(pageable).map(ProductTypeDTO::from);
    }

}
