package com.test.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SampleTest {

    private List emptyList;

    /**
     * sets up the test fixture
     */
    @Before
    public void setUp() {
        emptyList = new ArrayList();
    }

    /**
     * Tears down the test fixture
     */
    @After
    public void tearDown() {
        emptyList = null;
    }

    @Test
    public void testSomeBehavior() {
        assertEquals("Empty list should have 0 elements", 0, emptyList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testForException() {
        Object o = emptyList.get(0);
    }
}
