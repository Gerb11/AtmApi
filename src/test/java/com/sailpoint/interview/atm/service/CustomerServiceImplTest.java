package com.sailpoint.interview.atm.service;

import com.sailpoint.interview.atm.domain.Customer;
import com.sailpoint.interview.atm.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CustomerServiceImplTest {

    CustomerServiceImpl classUnderTest;

    CustomerRepository customerRepository = mock(CustomerRepository.class);

    @BeforeEach
    void setUp() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Jeremy", 1234, 1000.00));
        customerList.add(new Customer("Bill", 9876, 500.00));
        customerList.add(new Customer("Bob", 4321, 25.00));
        customerList.add(new Customer("Sam", 5432, 11234.00));
        Mockito.when(customerRepository.findAll()).thenReturn(customerList);

        classUnderTest = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void getCustomerSuccess() {
        Customer customer = classUnderTest.getCustomer("jeremy");
        assertEquals("Jeremy", customer.getName());
    }

    @Test
    void getCustomerFailed() {
        Customer customer = classUnderTest.getCustomer("Jill");
        assertNull(customer);
    }

}