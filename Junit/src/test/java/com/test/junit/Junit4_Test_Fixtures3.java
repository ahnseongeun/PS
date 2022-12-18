package com.test.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class Junit4_Test_Fixtures3 {

    private Collection<Object> collection;

    @Before
    public void setUp() {
        collection = new ArrayList<Object>();
    }

    @Test
    public void testEmptyCollection() {
        Assert.assertTrue(collection.isEmpty());
    }

    @Test
    public void testOneItemCollection() {
        collection.add("itemA");
        Assert.assertEquals(1, collection.size());
    }

    @Test
    public void whenAssertingEquality_thenEqual() {
        String expected = "Ramesh";
        String actual = "Ramesh";
        Assert.assertEquals(expected, actual);
    }
}
