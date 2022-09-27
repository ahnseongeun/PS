package chapter8_arrange_act_assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashAAATest {

    @Test
    void testPlus() {
        // Arrange
        var cash = new Cash(3);
        // Act
        cash.plus(4);
        // Assert
        assertEquals(7, cash.count());
    }

    @Test
    void testMinus() {
        // Arrange
        var cash = new Cash(8);
        // Act
        var result = cash.minus(5);
        // Assert
        assertTrue(result);
        assertEquals(3, cash.count());
    }

    @Test
    void testInsufficientMinus() {
        // Arrange
        var cash = new Cash(1);
        // Act
        var result = cash.minus(6);
        // Assert
        assertFalse(result);
        assertEquals(1, cash.count());
    }

    @Test
    void testUpdate() {
        // Arrange
        var cash = new Cash(5);
        // Act
        cash.plus(6);
        var result = cash.minus(3);
        // Assert
        assertTrue(result);
        assertEquals(8, cash.count());
    }
}