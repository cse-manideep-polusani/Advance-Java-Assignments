/**
 * 
 */
package com.calculator.test;

/**
 * 
 */

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.calculator.demo.Calculator;
public class CalculatorTest {
	
	private Calculator c;
	
	@BeforeEach
	void setUp() {
		c = new Calculator();
	}
	
	@Test
	@DisplayName("Test addition with two numbers")
	public void testAdditionOfOneAndOneGivesTwo() {
		assertEquals(2, c.add(1, 1));
	}
	
	@RepeatedTest(5)
	@DisplayName("Test addition with repeated execution")
	public void testAdditionOfZeroAndNineGivesNine() {
		assertEquals(9, c.add(0, 9));
	}
	
	
	
	@Nested
	@DisplayName("Subtraction Tests")
	class SubtractionTests{
		
		@Test
		@DisplayName("Test Subtraction of two numbers")
		void testSubtraction() {
			assertEquals(1 , c.subtract(5,4), "5 - 4 should give 1");
		}
		
		@Test
		@DisplayName("Test Subtraction of two numbers")
		void testSubtraction1() {
			assertEquals(1 , c.subtract(5,4), "5 - 4 should give 1");
		}
	}
	
	
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5})
	@DisplayName("Test multiplication of numbers by 2")
	void testMultiplyByTwo(int number) {
		assertEquals(number * 2,c.multiply(number,2),"Multiplication");
	}
	
	@ParameterizedTest
	@CsvSource({"2,2,4","2,3,6","4,4,17"})
	void testMultiplyByTwo(int x,int y,int expected) {
		assertEquals(expected,c.multiply(x,y));
	}
	
	
}
