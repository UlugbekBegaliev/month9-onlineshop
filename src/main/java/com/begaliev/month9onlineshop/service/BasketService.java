package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.dto.BasketDTO;
import com.begaliev.month9onlineshop.dto.ProductDTO;
import com.begaliev.month9onlineshop.exeption.ProductNotFoundException;
import com.begaliev.month9onlineshop.model.Basket;
import com.begaliev.month9onlineshop.model.Customer;
import com.begaliev.month9onlineshop.model.Product;
import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.repository.CustomerRepository;
import com.begaliev.month9onlineshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public List<BasketDTO> getBasket(List<BasketDTO> basket, Authentication authentication) {
//        Optional<Customer> customer = customerRepository.findByEmail(authentication.name());
//        List<Basket> baskets = basketRepository.findAllByCustomerId(customer.get().getId());
        return basket;
    }

    public void addToBasket(ProductDTO productDTO, List<BasketDTO> basketSession, Authentication authentication) {

        Customer customer = customerRepository.findByEmail(authentication.name()).get();

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
