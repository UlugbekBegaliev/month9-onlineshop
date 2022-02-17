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

    @GetMapping("/audies")
    public String getAudies(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        model.addAttribute("product", "Audi");
        var products = productService.getAllByTypeId(1, pageable);
        var uri = uriBuilder.getRequestURI();
        PropertiesService.constructPageable(products, propertiesService.getDefaultPageSize(), model, uri);

        return "product";
    }

    @GetMapping("/bmwes")
    public String getBmwes(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        model.addAttribute("product", "BMW");
        var products = productService.getAllByTypeId(2, pageable);
        var uri = uriBuilder.getRequestURI();
        PropertiesService.constructPageable(products, propertiesService.getDefaultPageSize(), model, uri);

        return "product";
    }

    @GetMapping("/mercedeses")
    public String getMercedeses(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        model.addAttribute("product", "Mercedes");
        var products = productService.getAllByTypeId(3, pageable);
        var uri = uriBuilder.getRequestURI();
        PropertiesService.constructPageable(products, propertiesService.getDefaultPageSize(), model, uri);

        return "product";
    }

    @GetMapping("/toyotas")
    public String getToyotas(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        model.addAttribute("product", "Toyota");
        var products = productService.getAllByTypeId(4, pageable);
        var uri = uriBuilder.getRequestURI();
        PropertiesService.constructPageable(products, propertiesService.getDefaultPageSize(), model, uri);

        return "product";
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {

        model.addAttribute("resource", ex);
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }
}