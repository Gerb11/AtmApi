package com.sailpoint.interview.atm.service;

import com.sailpoint.interview.atm.domain.Customer;
import com.sailpoint.interview.atm.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String name) {
        Iterable<Customer> customerIterable = customerRepository.findAll();
        for (Customer returnCustomer : customerIterable) {
            if (returnCustomer.getName().equalsIgnoreCase(name)) {
                return returnCustomer;
            }
        }
        return null;
    }

    @Override
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
