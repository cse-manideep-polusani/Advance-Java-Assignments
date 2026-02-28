/**
 * 
 */
package com.capgemini.JunitTasks;

/**
 * 
 */

public class CartService {

    // Calculate total price
    public double calculateTotal(double item1, double item2, double item3) {
        return item1 + item2 + item3;
    }

    // Calculate discount
    public double calculateDiscount(double total) {
        if (total >= 5000) {
            return total * 0.10; // 10% discount
        }
        return 0;
    }

    // Calculate final payable amount
    public double calculateFinalAmount(double total, double discount) {
        return total - discount;
    }
}

