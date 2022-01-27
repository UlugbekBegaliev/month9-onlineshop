package com.begaliev.month9onlineshop.controller;

import com.begaliev.month9onlineshop.dto.ProductTypeDTO;
import com.begaliev.month9onlineshop.service.ProductService;
import com.begaliev.month9onlineshop.service.ProductTypeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product-types")
public class ProductTypeController {

    private final ProductService productService;
    private final ProductTypeService productTypeService;

    @GetMapping
    public List<ProductTypeDTO> getAll(Pageable pageable){
        return productTypeService.getAll(pageable).getContent();
    }
}
