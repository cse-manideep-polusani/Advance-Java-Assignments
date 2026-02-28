/**
 * 
 */
package com.capgemini.JunitTasks;

/**
 * 
 */

public class LeaveService {

    // Calculate available leave balance
    public int getAvailableLeaves(int totalLeavesAllocated, int leavesTaken) {
        return totalLeavesAllocated - leavesTaken;
    }

    // Approve or reject leave request
    public boolean approveLeave(int totalLeavesAllocated, int leavesTaken, int leaveRequestDays) {
        if (leaveRequestDays <= 0) {
            throw new IllegalArgumentException("Leave request days must be greater than 0");
        }

        int availableLeaves = getAvailableLeaves(totalLeavesAllocated, leavesTaken);
        return leaveRequestDays <= availableLeaves;
    }

    // Calculate remaining leave balance after approval
    public int calculateRemainingLeaves(int totalLeavesAllocated,
                                        int leavesTaken,
                                        int approvedLeaveDays) {
        return totalLeavesAllocated - leavesTaken - approvedLeaveDays;
    }

    // Apply leave (used for exception testing)
    public void applyLeave(int leaveRequestDays) {
        if (leaveRequestDays <= 0) {
            throw new IllegalArgumentException("Invalid leave request");
        }
    }
}

