/**
 * 
 */
package com.capgemini.JunitTasks;

/**
 * 
 */

public class StudentService {

    
    public int calculateTotal(int m1, int m2, int m3) {
        return m1 + m2 + m3;
    }

   
    public double calculateAverage(int m1, int m2, int m3) {
        int total = calculateTotal(m1, m2, m3);
        return total / 3.0;
    }

   
    public boolean isPassed(int m1, int m2, int m3) {
        double average = calculateAverage(m1, m2, m3);
        return average >= 40;
    }
}
