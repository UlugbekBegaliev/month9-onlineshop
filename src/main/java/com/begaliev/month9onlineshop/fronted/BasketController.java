package com.begaliev.month9onlineshop.fronted;

import com.begaliev.month9onlineshop.repository.BasketRepository;
import com.begaliev.month9onlineshop.service.BasketService;
import com.begaliev.month9onlineshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final ProductService productService;

//    @GetMapping
//    public String basket(Model model, )
}
