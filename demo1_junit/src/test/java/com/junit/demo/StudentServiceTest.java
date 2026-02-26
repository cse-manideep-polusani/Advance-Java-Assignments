package com.junit.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentServiceTest {

    StudentService service;
    Student student;

    @BeforeEach
    void setUp() {
        service = new StudentService();
        student = new Student(101, "Rahul", 80, 70, 90);
    }

    @Test
    void testTotalMarks() {
        assertEquals(240, service.calculateTotal(student));
    }

    @Test
    void testAverageMarks() {
        assertEquals(80.0, service.calculateAverage(student));
    }

    @Test
    void testStudentPass() {
        assertTrue(service.isPassed(student));
    }

    @Test
    void testStudentFail() {
        Student weakStudent = new Student(102, "Amit", 30, 35, 40);
        assertFalse(service.isPassed(weakStudent));
    }
}
