package com.sailpoint.interview.atm.controller;

import com.sailpoint.interview.atm.domain.Customer;
import com.sailpoint.interview.atm.service.CustomerService;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ATMController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance(Authentication authentication) {
        Customer customer = customerService.getCustomer(authentication.getName());
        return ResponseEntity.ok().body(Precision.round(customer.getBalance(), 2));
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> depositMoney(@RequestBody double amount,
                                               Authentication authentication) {
        Customer customer = customerService.getCustomer(authentication.getName());
        customer.addBalance(amount);
        customerService.saveCustomer(customer);
        return ResponseEntity.ok().body("Balance added. View new balance using /balance");
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<String> withdrawalMoney(@RequestBody double amount,
                                  Authentication authentication) {
        Customer customer = customerService.getCustomer(authentication.getName());
        boolean balanceRemoved = customer.removeBalance(amount);
        if (balanceRemoved) {
            customerService.saveCustomer(customer);
            return ResponseEntity.ok().body("Here's your " + amount + ". View new balance with /balance");
        } else {
            return ResponseEntity.badRequest().body("Tried to retrieve more than current balance.");
        }
    }

}
