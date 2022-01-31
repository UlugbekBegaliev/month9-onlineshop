package com.begaliev.month9onlineshop.controller;

import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.service.BasketService;
import com.begaliev.month9onlineshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final ProductService productService;

//    @GetMapping
//    public String basket(Model model, )
}
