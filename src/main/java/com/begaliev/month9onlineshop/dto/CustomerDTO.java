package com.begaliev.month9onlineshop.dto;

import com.begaliev.month9onlineshop.model.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {

    private int id;
    private String fullname;
    private String email;

    public static CustomerDTO from(Customer user){
        return builder()
                .id(user.getId())
                .fullname(user.getFullname())
                .email(user.getEmail())
                .build();
    }
}
