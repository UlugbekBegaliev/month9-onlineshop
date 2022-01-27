package com.begaliev.month9onlineshop.controller;

import com.begaliev.month9onlineshop.dto.CustomerDTO;
import com.begaliev.month9onlineshop.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Page<CustomerDTO> getAll(Pageable pageable){
        return customerService.getAll(pageable);
    }
}
