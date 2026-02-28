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

class LeaveServiceTest {

    private LeaveService leaveService;

    @BeforeEach
    void setUp() {
        leaveService = new LeaveService();
    }

    // Test Case 1: Check Leave Balance Calculation
    @Test
    void testAvailableLeaveBalance() {
        int availableLeaves = leaveService.getAvailableLeaves(20, 10);
        assertEquals(10, availableLeaves);
    }

    // Test Case 2: Approve Leave Request
    @Test
    void testApproveLeaveRequest() {
        boolean result = leaveService.approveLeave(20, 10, 5);
        assertTrue(result);
    }

    // Test Case 3: Reject Leave Request (Insufficient Balance)
    @Test
    void testRejectLeaveRequest() {
        boolean result = leaveService.approveLeave(20, 10, 15);
        assertFalse(result);
    }

    // Test Case 4: Remaining Leave Balance After Approval
    @Test
    void testRemainingLeaveBalanceAfterApproval() {
        int remainingLeaves = leaveService.calculateRemainingLeaves(20, 10, 5);
        assertEquals(5, remainingLeaves);
    }

    // Test Case 5: Invalid Leave Request (Negative or Zero Days)
    @Test
    void testInvalidLeaveRequest() {
        assertThrows(IllegalArgumentException.class,
                () -> leaveService.applyLeave(-2));
    }
}
