/**
 * 
 */
package com.capgemini.JunitTasks;

/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartServiceTest {

    private CartService cartService;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
    }

    // Test Case 1: Calculate Total Price
    @Test
    void testCalculateTotalPrice() {
        double total = cartService.calculateTotal(1500, 2000, 1000);
        assertEquals(4500, total);
    }

    // Test Case 2: Discount Applied Case
    @Test
    void testDiscountApplied() {
        double total = cartService.calculateTotal(2000, 2000, 1000); // 5000
        double discount = cartService.calculateDiscount(total);
        assertEquals(500, discount);
    }

    // Test Case 3: No Discount Case
    @Test
    void testNoDiscount() {
        double total = cartService.calculateTotal(1500, 2000, 900); // 4400
        double discount = cartService.calculateDiscount(total);
        assertEquals(0, discount);
    }

    // Test Case 4: Final Payable Amount
    @Test
    void testFinalPayableAmount() {
        double total = cartService.calculateTotal(2000, 2000, 1000); // 5000
        double discount = cartService.calculateDiscount(total);
        double finalAmount = cartService.calculateFinalAmount(total, discount);
        assertEquals(4500, finalAmount);
    }
}
