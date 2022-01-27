package com.begaliev.month9onlineshop.dto;

import com.begaliev.month9onlineshop.model.ProductType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeDTO {

    private Integer id;
    private String name;
    private String icon;

    public static ProductTypeDTO from(ProductType productType){
        return ProductTypeDTO.builder()
                .id(productType.getId())
                .name(productType.getName())
                .icon(productType.getIcon())
                .build();
    }
}
