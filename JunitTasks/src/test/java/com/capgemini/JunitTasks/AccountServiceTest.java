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

class AccountServiceTest {

    private AccountService accountService;
    private double balance;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
        balance = 5000.0;
    }

    // Test Case 1: Deposit Amount
    @Test
    void testDepositAmount() {
        double updatedBalance = accountService.deposit(balance, 1000);
        assertEquals(6000, updatedBalance);
    }

    // Test Case 2: Withdraw Amount
    @Test
    void testWithdrawAmount() {
        double updatedBalance = accountService.withdraw(balance, 2000);
        assertEquals(3000, updatedBalance);
    }

    // Test Case 3: Withdrawal More Than Balance
    @Test
    void testWithdrawalMoreThanBalance() {
        boolean result = accountService.canWithdraw(balance, 6000);
        assertFalse(result);
    }

    // Test Case 4: Minimum Balance Validation
    @Test
    void testMinimumBalanceValidation() {
        boolean result = accountService.hasMinimumBalance(1200);
        assertTrue(result);
    }
}

