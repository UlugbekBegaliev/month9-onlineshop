package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.repository.CustomerRepository;
import com.begaliev.month9onlineshop.repository.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;
    private final BasketRepository basketRepository;

}
