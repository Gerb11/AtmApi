package com.sailpoint.interview.atm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    int pin;

    @Column(nullable = false)
    double balance;

    public Customer() {
    }

    public Customer(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double addedValue) {
        balance = balance + addedValue;
    }

    public boolean removeBalance(double removedValue) {
        if (balance - removedValue < 0) {
            return false;
        }
        balance = balance - removedValue;
        return true;
    }
}
