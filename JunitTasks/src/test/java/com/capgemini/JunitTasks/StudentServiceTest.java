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

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    // Test Case 1: Calculate Total Marks
    @Test
    void testCalculateTotalMarks() {
        int total = studentService.calculateTotal(80, 90, 70);
        assertEquals(240, total);
    }

    // Test Case 2: Calculate Average Marks
    @Test
    void testCalculateAverageMarks() {
        double average = studentService.calculateAverage(80, 90, 70);
        assertEquals(80.0, average);
    }

    // Test Case 3: Student Pass Case
    @Test
    void testStudentPass() {
        boolean result = studentService.isPassed(60, 50, 40);
        assertTrue(result);
    }

    // Test Case 4: Student Fail Case
    @Test
    void testStudentFail() {
        boolean result = studentService.isPassed(30, 35, 40);
        assertFalse(result);
    }
}
