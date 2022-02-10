package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.dto.PurchaseDTO;
import com.begaliev.month9onlineshop.exeption.CustomerNotFoundException;
import com.begaliev.month9onlineshop.model.Customer;
import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.repository.CustomerRepository;
import com.begaliev.month9onlineshop.repository.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;
    private final BasketRepository basketRepository;

    public Page<PurchaseDTO> getPurchases(Pageable pageable, Authentication authentication) {

        Customer customer = customerRepository.findByEmail(authentication.getName())
                .orElseThrow(CustomerNotFoundException::new);

        return purchaseRepository.finAllByCustomerId(customer.getId(), pageable).map(PurchaseDTO::from);
        )
    }

}
