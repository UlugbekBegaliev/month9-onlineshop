package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.exeption.CustomerNotFoundException;
import com.begaliev.month9onlineshop.model.Customer;
import com.begaliev.month9onlineshop.model.PasswordManager;
import com.begaliev.month9onlineshop.repository.CustomerRepository;
import com.begaliev.month9onlineshop.repository.PasswordManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PasswordManagerService {

    private final PasswordManagerRepository passwordManagerRepository;
    private final CustomerRepository customerRepository;
    private final EmailServiceImpl emailService;

    public void createToken(String email){

        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(CustomerNotFoundException::new);
        PasswordManager token = PasswordManager.builder()
                .customer(customer)
                .token(UUID.randomUUID().toString())
                .build();

        passwordManagerRepository.deleteAll();
        passwordManagerRepository.save(token);

        emailService.sendSimpleMessage(customer.getEmail(),
                "onlineshop | Password Recovery", "Token: " + token.getToken());
    }

    public boolean existsByToken(String token){
        return passwordManagerRepository.existsByToken(token);
    }
}
