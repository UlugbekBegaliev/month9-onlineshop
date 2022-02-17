package com.begaliev.month9onlineshop.controller;

import com.begaliev.month9onlineshop.dto.ProductDTO;
import com.begaliev.month9onlineshop.dto.ProductTypeDTO;
import com.begaliev.month9onlineshop.service.ProductService;
import com.begaliev.month9onlineshop.service.ProductTypeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product-types")
public class ProductTypeRestController {

    private final ProductService productService;
    private final ProductTypeService productTypeService;

    @GetMapping
    public List<ProductTypeDTO> getAll(Pageable pageable){
        return productTypeService.getAll(pageable).getContent();
    }

    @GetMapping("/{typeId}/products")
    public List<ProductDTO> getAllByTypeId(@PathVariable int typeId, Pageable pageable){
        return productService.getAllByTypeId(typeId, pageable).getContent();
    }
}
