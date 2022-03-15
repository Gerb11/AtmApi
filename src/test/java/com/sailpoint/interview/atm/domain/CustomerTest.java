package com.sailpoint.interview.atm.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest = new Customer();
    }

    @Test
    void addBalance() {
        classUnderTest.addBalance(50);
        assertEquals(50, classUnderTest.getBalance());

        classUnderTest.addBalance(100);
        assertEquals(150, classUnderTest.getBalance());
    }

    @Test
    void removeBalance() {
        classUnderTest = new Customer("test", 1234, 1000);
        classUnderTest.removeBalance(500);
        assertEquals(500, classUnderTest.getBalance());

        classUnderTest.removeBalance(250);
        assertEquals(250, classUnderTest.getBalance());
    }
}