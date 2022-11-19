package com.edocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edocode.model.Accounts;
import com.edocode.model.Customer;
import com.edocode.repository.AccountsRepository;
import com.edocode.repository.CustomerRepository;

@RestController
public class AccountController {
    
    @Autowired
    private AccountsRepository accountsRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
    	List<Customer> customers = customerRepository.findByEmail(email);
    	
    	if (customers != null && !customers.isEmpty()) {
    		Accounts account = accountsRepository.findByCustomerId(customers.get(0).getId());
            if (account != null ) {
                return account;
            }
    	}
    	return null;
    }

}
