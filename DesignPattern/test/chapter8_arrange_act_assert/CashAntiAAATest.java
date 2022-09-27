package chapter8_arrange_act_assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashAntiAAATest {

    @Test
    void testCash() {
        //initialize
        var cash = new Cash(3);
        //test plus
        cash.plus(4);
        assertEquals(7, cash.count());
        //test minus
        cash = new Cash(8);
        assertTrue(cash.minus(5));
        assertEquals(3, cash.count());
        assertFalse(cash.minus(6));
        assertEquals(3, cash.count());
        //test update
        cash.plus(5);
        assertTrue(cash.minus(5));
        assertEquals(3, cash.count());
    }

}