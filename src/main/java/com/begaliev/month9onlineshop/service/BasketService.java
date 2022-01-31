package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.dto.BasketDTO;
import com.begaliev.month9onlineshop.model.Basket;
import com.begaliev.month9onlineshop.model.Customer;
import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.repository.CustomerRepository;
import com.begaliev.month9onlineshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
//
//    public List<BasketDTO> getBasket(List<BasketDTO> basket, Authentication authentication){
//        Customer customer = customerRepository.findByEmail(authentication.name().trim());
//        List<Basket> baskets = basketRepository.findAllByCustomerId(customer.getId());
//        return basket;
//    }
}
