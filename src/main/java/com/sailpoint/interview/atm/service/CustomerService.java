package com.sailpoint.interview.atm.service;

import com.sailpoint.interview.atm.domain.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer getCustomer(String name);

    Iterable<Customer> getAllCustomers();

}
