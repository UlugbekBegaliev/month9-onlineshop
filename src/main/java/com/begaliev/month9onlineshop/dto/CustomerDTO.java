package com.begaliev.month9onlineshop.dto;

import com.begaliev.month9onlineshop.model.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {

    private int id;
    private String fullName;
    private String email;

    public static CustomerDTO from(Customer user){
        return builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();
    }
}
