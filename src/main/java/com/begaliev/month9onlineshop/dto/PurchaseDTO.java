package com.begaliev.month9onlineshop.dto;

import com.begaliev.month9onlineshop.model.Purchase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseDTO {

    private Integer id;
    private CustomerDTO customer;
    private String productName;
    private float price;
    private float quantity;

    public static PurchaseDTO from(Purchase purchase) {
        return PurchaseDTO.builder()
                .id(purchase.getId())
                .customer(CustomerDTO.from(purchase.getCustomer()))
                .productName(purchase.getProductName())
                .price(purchase.getPrice())
                .quantity(purchase.getQuantity())
                .build();
    }
}
