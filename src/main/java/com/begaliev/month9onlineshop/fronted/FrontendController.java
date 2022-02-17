package com.begaliev.month9onlineshop.fronted;

import com.begaliev.month9onlineshop.exeption.ResourceNotFoundException;
import com.begaliev.month9onlineshop.model.CustomerRegisterForm;
import com.begaliev.month9onlineshop.service.CustomerService;
import com.begaliev.month9onlineshop.service.PasswordManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {

    private final CustomerService customerService;
    private final PasswordManagerService passwordManagerService;

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal)
    {
        var user = customerService.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "profile";
    }

    @GetMapping("/register")
    public String pageRegisterCustomer(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new CustomerRegisterForm());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerPage(@Valid CustomerRegisterForm customerRequestDto,
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

    @GetMapping("/forgot-password")
    public String pageForgotPassword(){
        return "forgot";
    }

    @PostMapping("forgot-password")
    public String resetPassword(@RequestParam("email") String email,
                                RedirectAttributes attributes){

        if (!customerService.existsByEmail(email)){
            attributes.addFlashAttribute("errorText", "Entered email does not exist");
            return "redirect:/forgot-password";
        }
        passwordManagerService.createToken(email);

        return "redirect:/forgot-success";
    }

    @GetMapping("/forgot-success")
    public String pageResetPassword(){
        return "forgot-success";
    }

    @PostMapping("/reset-password")
    public String submitResetPasswordPage(@RequestParam("token") String token,
                                          @RequestParam("newPassword") String newPassword,
                                          RedirectAttributes attributes) {
        if (!passwordManagerService.existsByToken(token)) {
            attributes.addFlashAttribute("errorText", "Entered email does not exist!");
            return "redirect:/reset-password";
        }
        customerService.resetPassword(token, newPassword);
        return "redirect:/login";
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model){

        model.addAttribute("resource", ex);
        model.addAttribute("id", ex.getId());

        return "resource-not-found";
    }
}
