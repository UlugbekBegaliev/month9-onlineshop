package com.begaliev.month9onlineshop.fronted;

import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.service.BasketService;
import com.begaliev.month9onlineshop.service.ProductService;
import com.begaliev.month9onlineshop.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@AllArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final ProductService productService;
    private final PurchaseService purchaseService;



}
