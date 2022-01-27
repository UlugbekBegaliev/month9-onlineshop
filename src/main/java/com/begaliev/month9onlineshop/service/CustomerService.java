package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.dto.CustomerDTO;
import com.begaliev.month9onlineshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Page<CustomerDTO> getAll(Pageable pageable){
        return customerRepository.findAll(pageable).map(CustomerDTO::from);
    }
}
