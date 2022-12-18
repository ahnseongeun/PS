package com.test.junit;

import com.test.junit.domain.Customer;
import org.junit.jupiter.api.BeforeEach;

public class Junit4_Test_Fixtures1 {
    private Customer customer;
    private static final int ID = 1;
    private static final String FIRSTNAME = "Winston";
    private static final String LASTNAME = "Churchill";

    /**
     * @BeforeEach는 @Test 실행전에 매번 한번씩 실행된다.
     */
    @BeforeEach
    public void setUp() {
        customer = new Customer(ID, FIRSTNAME, LASTNAME);
    }
}
