package com.begaliev.month9onlineshop.controller;

import com.begaliev.month9onlineshop.service.CustomerService;
import com.begaliev.month9onlineshop.service.PasswordManagerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PasswordManagerController {

    private final PasswordManagerService passwordManagerService;
    private final CustomerService customerService;

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model){
        model.addAttribute("error", error);
        return "login";
    }


}
