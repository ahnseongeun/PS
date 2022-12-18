package com.test.junit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Closeable;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
public class Junit4_Test_Fixtures2 {

    private ManagedResource managedResource;
    private static ExpensiveManagedResource expensiveManagedResource;

    static class ExpensiveManagedResource implements Closeable {
        @Override
        public void close() throws IOException {

        }
    }

    static class ManagedResource implements Closeable {
        @Override
        public void close() throws IOException {

        }
    }

    @Before
    public void setUp() {
        System.out.println("@Before setUp");
        this.managedResource = new ManagedResource();
    }

    @After
    public void tearDown() throws IOException{
        System.out.println("@After tearDown");
        this.managedResource.close();
        this.managedResource = null;
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass setUpClass");
        expensiveManagedResource = new ExpensiveManagedResource();
    }

    @AfterClass
    public static void tearDownClass() throws IOException{
        System.out.println("@AfterClass tearDownClass");
        expensiveManagedResource.close();
        expensiveManagedResource = null;
    }

    @Test
    public void test1() {
        System.out.println("@Test test1()");
    }

    @Test
    public void test2() {
        System.out.println("@Test test2()");
    }

}
