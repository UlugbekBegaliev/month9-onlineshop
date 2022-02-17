package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.dto.BasketDTO;
import com.begaliev.month9onlineshop.dto.PurchaseDTO;
import com.begaliev.month9onlineshop.exeption.CustomerNotFoundException;
import com.begaliev.month9onlineshop.exeption.ProductNotFoundException;
import com.begaliev.month9onlineshop.model.Basket;
import com.begaliev.month9onlineshop.model.Customer;
import com.begaliev.month9onlineshop.model.Purchase;
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

    public Page<PurchaseDTO> getPurchases(Authentication authentication, Pageable pageable) {

        Customer customer = customerRepository.findByEmail(authentication.getName())
                .orElseThrow(CustomerNotFoundException::new);

        return purchaseRepository.finAllByCustomerId(customer.getId(), pageable).map(PurchaseDTO::from);
    }

    public void purchase(BasketDTO basketDTO) {
        Basket basket = basketRepository.findById(basketDTO.getId()).orElseThrow(ProductNotFoundException::new);

        Purchase purchase = Purchase.builder()
                .customer(basket.getCustomer())
                .price(basket.getPrice())
                .productName(basket.getProductName())
                .quantity(basket.getQuantity())
                .build();

        purchaseRepository.save(purchase);
        basketRepository.deleteById(basketDTO.getId());
    }
}
