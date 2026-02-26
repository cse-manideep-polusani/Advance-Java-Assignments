package com.capgemini.hibernate.demo1_junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("Test sum of two positive numbers")
	void testSumOfPositiveNumbers() {
		assertEquals(5, calculator.sum(2, 3), "Sum of 2 and 3 should be 5");
	}

	@Test
	@DisplayName("Test sum of two negative numbers")
	void testSumOfNegativeNumbers() {
		assertEquals(-5, calculator.sum(-2, -3), "Sum of -2 and -3 should be -5");
	}

	@RepeatedTest(3)
	@DisplayName("Test sum with repeated execution")
	void testSumRepeated() {
		assertEquals(10, calculator.sum(5, 5), "Sum of 5 and 5 should be 10");
	}

	@Nested
	@DisplayName("Subtraction Tests")
	class SubtractionTests {

		@Test
		@DisplayName("Test subtraction of two numbers")
		void testSubtraction() {
			assertEquals(1, calculator.subtract(5, 4), "5 - 4 should be 1");
		}

		@Test
		@DisplayName("Test subtraction with negative result")
		void testSubtractionNegative() {
			assertEquals(-1, calculator.subtract(4, 5), "4 - 5 should be -1");
		}
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5 })
	@DisplayName("Test multiplication of numbers by 2")
	void testMultiplyByTwo(int number) {
		assertEquals(number * 2, calculator.multiply(number, 2), "Multiplying by 2 should return correct result");
	}
	@ParameterizedTest
	@CsvSource({"2,2,4","2,3,6","4,4,16"})
	void testMultiply(int x,int y,int expected) {
		assertEquals(expected, calculator.multiply(x, y));
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/calculator-data.csv",numLinesToSkip = 1)
	@DisplayName("Test sum using CSV file")
	void testSumUsingCsvFile(int a, int b, int expectedSum) {
	    assertEquals(expectedSum, calculator.sum(a, b),
	            () -> "Sum of " + a + " and " + b + " should be " + expectedSum);
	}

	@Test
	@DisplayName("Test division with non-zero denominator")
	void testDivide() {
		assertEquals(2.0, calculator.divide(10, 5), "10 divided by 5 should be 2");
		
	}

	@Test
	@DisplayName("Test division by zero")
	void testDivideByZero() {
		assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
	}
}
