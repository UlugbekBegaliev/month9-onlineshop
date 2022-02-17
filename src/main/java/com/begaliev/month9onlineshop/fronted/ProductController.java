package com.begaliev.month9onlineshop.fronted;

import com.begaliev.month9onlineshop.exeption.ResourceNotFoundException;
import com.begaliev.month9onlineshop.service.ProductService;
import com.begaliev.month9onlineshop.service.PropertiesService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model){

        model.addAttribute("resource", ex);
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }
}
