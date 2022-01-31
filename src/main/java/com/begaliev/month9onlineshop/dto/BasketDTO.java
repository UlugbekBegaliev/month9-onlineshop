package com.begaliev.month9onlineshop.dto;

import com.begaliev.month9onlineshop.model.Basket;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketDTO {

    private int id;
    private String productName;
    private float quantity;
    private float price;
    private CustomerDTO customer;

    public static BasketDTO from(Basket basket){
        return BasketDTO.builder()
                .id(basket.getId())
                .productName(basket.getProductName())
                .quantity(basket.getQuantity())
                .price(basket.getPrice())
                .customer(CustomerDTO.from(basket.getCustomer()))
                .build();
    }
}
