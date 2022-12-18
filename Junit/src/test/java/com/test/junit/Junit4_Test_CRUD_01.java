package com.test.junit;

import com.test.junit.domain.Customer;
import com.test.junit.domain.CustomerService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Junit4_Test_CRUD_01 {

    private Customer customer;

    @Autowired
    private CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        customer = new Customer();
        customer.setId(1);
        customer.setFirstName("SEONGEUN");
        customer.setLastName("AHN");
    }

    @Test
    public void testAddCustomer() {
        Customer newCustomer = customerService.add(customer);
        Assert.assertNotNull("School Type object should not null", newCustomer);
    }

    @Test
    public void testUpdateCustomer() {
        Customer newCustomer = customerService.add(customer);
        Assert.assertNotNull(newCustomer);
        newCustomer.setLastName("LEE");
        customerService.update(newCustomer);
    }

    @After
    public void tearDown() throws Exception {
        customerService.delete(customer);
    }
}

