package com.test.junit.domain;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public Customer add(Customer customer) {
        return customer;
    }

    public void update(Customer newCustomer) {
        System.out.println("update customer");
    }

    public void delete(Customer customer) {
        System.out.println("delete customer");
    }
}
