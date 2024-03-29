package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.dto.BasketDTO;
import com.begaliev.month9onlineshop.dto.ProductDTO;
import com.begaliev.month9onlineshop.exeption.CustomerNotFoundException;
import com.begaliev.month9onlineshop.exeption.ProductNotFoundException;
import com.begaliev.month9onlineshop.model.Basket;
import com.begaliev.month9onlineshop.model.Customer;
import com.begaliev.month9onlineshop.model.Product;
import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.repository.CustomerRepository;
import com.begaliev.month9onlineshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public List<BasketDTO> getBasket(List<BasketDTO> basket, Authentication authentication) {

        if(basketRepository.count() != basket.size()){
            basket.clear();
            Customer customer = customerRepository.findByEmail(authentication.getName()).orElseThrow(CustomerNotFoundException::new);
            List<Basket> baskets = basketRepository.findAllByCustomerId(customer.getId());
            List<BasketDTO> basketDTOS = baskets.stream().map(BasketDTO::from).collect(Collectors.toList());
            basket.addAll(basketDTOS);

            return basket;
        }
        return basket;
    }

    public void addToBasket(ProductDTO productDTO, List<BasketDTO> basketSession, Authentication authentication) {

        Customer customer = customerRepository.findByEmail(authentication.getName()).get();

        Product product = productRepository.findById(productDTO.getId())
                .orElseThrow(ProductNotFoundException::new);

        if (basketSession != null){

            Basket basket = Basket.builder()
                    .price(product.getPrice() * productDTO.getQuantity())
                    .productName(product.getName())
                    .customer(customer)
                    .quantity(productDTO.getQuantity())
                    .build();

            basketRepository.save(basket);

            basketSession.add(BasketDTO.from(basket));
        }
    }

    public void deleteBasket(Integer id){
        basketRepository.deleteById(id);
    }
}
