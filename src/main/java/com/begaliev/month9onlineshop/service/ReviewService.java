package com.begaliev.month9onlineshop.service;


import com.begaliev.month9onlineshop.dto.ReviewDTO;
import com.begaliev.month9onlineshop.exeption.CustomerNotFoundException;
import com.begaliev.month9onlineshop.exeption.ProductNotFoundException;
import com.begaliev.month9onlineshop.model.Customer;
import com.begaliev.month9onlineshop.model.Product;
import com.begaliev.month9onlineshop.model.Review;
import com.begaliev.month9onlineshop.repository.CustomerRepository;
import com.begaliev.month9onlineshop.repository.ProductRepository;
import com.begaliev.month9onlineshop.repository.PurchaseRepository;
import com.begaliev.month9onlineshop.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final ReviewRepository reviewRepository;

    public void review(Integer id, String description, Authentication authentication) {
        Customer customer = customerRepository.findByEmail(authentication.getName())
                .orElseThrow(CustomerNotFoundException::new);
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if (purchaseRepository.existsByCustomerId(customer.getId())) {
            Review review = Review.builder()
                    .customer(customer)
                    .product(product)
                    .description(description)
                    .build();
            reviewRepository.save(review);
        }
    }

    public List<ReviewDTO> getReviewsByProductId(Integer id) {
        List<Review> reviews = reviewRepository.findAllByProductId(id);
        List<ReviewDTO> reviewDTOS = reviews.stream()
                .map(ReviewDTO::from)
                .collect(Collectors.toList());

        return reviewDTOS;
    }
}
