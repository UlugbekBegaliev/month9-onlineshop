package com.begaliev.month9onlineshop.dto;

import com.begaliev.month9onlineshop.model.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private String image;
    private int quantity;
    private float price;
    private ProductTypeDTO type;

    public static ProductDTO from(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .image(product.getImage())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .type(ProductTypeDTO.from(product.getType()))
                .build();
    }
}
