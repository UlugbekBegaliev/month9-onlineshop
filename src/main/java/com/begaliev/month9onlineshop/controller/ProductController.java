package com.begaliev.month9onlineshop.controller;

import com.begaliev.month9onlineshop.dto.ProductDTO;
import com.begaliev.month9onlineshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public List<ProductDTO> getAll(Pageable pageable){
        return productService.getAll(pageable).getContent();
    }
}
