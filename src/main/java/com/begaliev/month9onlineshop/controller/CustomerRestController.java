package com.begaliev.month9onlineshop.controller;

import com.begaliev.month9onlineshop.dto.CustomerDTO;
import com.begaliev.month9onlineshop.model.Customer;
import com.begaliev.month9onlineshop.model.CustomerRegisterForm;
import com.begaliev.month9onlineshop.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerRestController {

    private final CustomerService customerService;

    @GetMapping
    public Page<CustomerDTO> getAll(Pageable pageable) {
        return customerService.getAll(pageable);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerPage(@Valid @RequestBody CustomerRegisterForm customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }
        customerService.register(customerRequestDto);
        return "redirect:/login";
    }

    public String save(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
        if (customer.getCaptcha().equals(request.getSession().getAttribute("captcha"))) {
            customerService.add(customer);
            return "redirect:/list";
        } else {
            return "redirect:/";
        }
    }
}
