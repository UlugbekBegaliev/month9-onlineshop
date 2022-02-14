package com.begaliev.month9onlineshop.dto;

import com.begaliev.month9onlineshop.model.Review;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDTO {

    private int id;
    private CustomerDTO customer;
    private ProductDTO product;
    private String description;

    public static ReviewDTO from(Review review){
        return ReviewDTO.builder()
                .id(review.getId())
                .customer(CustomerDTO.from(review.getCustomer()))
                .product(ProductDTO.from(review.getProduct()))
                .description(review.getDescription())
                .build();
    }
}
