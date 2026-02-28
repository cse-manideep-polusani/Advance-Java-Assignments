/**
 * 
 */
package com.capgemini.JunitTasks;

/**
 * 
 */

public class AccountService {

    private static final double MIN_BALANCE = 1000.0;

    // Deposit money into account
    public double deposit(double currentBalance, double amount) {
        if (amount <= 0) {
            return currentBalance;
        }
        return currentBalance + amount;
    }

    // Withdraw money from account
    public double withdraw(double currentBalance, double amount) {
        if (amount <= currentBalance) {
            return currentBalance - amount;
        }
        return currentBalance;
    }

    // Check if withdrawal is allowed
    public boolean canWithdraw(double currentBalance, double amount) {
        return amount <= currentBalance;
    }

    // Check minimum balance condition
    public boolean hasMinimumBalance(double balance) {
        return balance >= MIN_BALANCE;
    }
}

