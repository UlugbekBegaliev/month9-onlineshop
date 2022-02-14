package com.begaliev.month9onlineshop.service;


import com.begaliev.month9onlineshop.repository.CustomerRepository;
import com.begaliev.month9onlineshop.repository.ProductRepository;
import com.begaliev.month9onlineshop.repository.PurchaseRepository;
import com.begaliev.month9onlineshop.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final ReviewRepository reviewRepository;
}
