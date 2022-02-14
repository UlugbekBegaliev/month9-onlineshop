package com.begaliev.month9onlineshop.service;

import com.begaliev.month9onlineshop.dto.CustomerDTO;
import com.begaliev.month9onlineshop.exeption.CustomerAlreadyRegisteredException;
import com.begaliev.month9onlineshop.exeption.CustomerNotFoundException;
import com.begaliev.month9onlineshop.model.Customer;
import com.begaliev.month9onlineshop.model.CustomerRegisterForm;
import com.begaliev.month9onlineshop.model.PasswordManager;
import com.begaliev.month9onlineshop.repository.CustomerRepository;
import com.begaliev.month9onlineshop.repository.PasswordManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;
    private final PasswordManagerRepository passwordManagerRepository;

    public Page<CustomerDTO> getAll(Pageable pageable){
        return customerRepository.findAll(pageable).map(CustomerDTO::from);
    }

    public CustomerDTO register(CustomerRegisterForm form) {
        if (customerRepository.existsByEmail(form.getEmail())){
            throw new CustomerAlreadyRegisteredException();
        }

        var user = Customer.builder()
                .email(form.getEmail())
                .fullname(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        return CustomerDTO.from(user);
    }

    public CustomerDTO getByEmail(String email) {
        var user = customerRepository.findByEmail(email)
                .orElseThrow(CustomerNotFoundException::new);

        return CustomerDTO.from(user);
    }

    public boolean existsByEmail(String email){
        return customerRepository.existsByEmail(email);
    }

    public void add(Customer customer) {
        customerRepository.findByEmail(customer.getEmail());
    }

    public void resetPassword(String token, String newPassword){
        PasswordManager resetPassword = passwordManagerRepository.findByToken(token).get();
        Customer customer = customerRepository.findById(resetPassword.getCustomer().getId()).get();
        customer.setPassword(new BCryptPasswordEncoder().encode(newPassword));

        customerRepository.save(customer);
    }
}
