package com.begaliev.month9onlineshop.fronted;

import com.begaliev.month9onlineshop.service.ProductService;
import com.begaliev.month9onlineshop.service.PropertiesService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final PropertiesService propertiesService;

    @GetMapping
    public String index(Model model, Pageable pageable, HttpServletRequest uriBuilder) {

        var products = productService.getAll(pageable);
        String uri = uriBuilder.getRequestURI();
        PropertiesService.constructPageable(products, propertiesService.getDefaultPageSize(), model, uri);

        return "index";
    }
}
