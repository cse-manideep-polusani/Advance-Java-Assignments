/**
 * 
 */
package mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * 
 */

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
	
	@Mock
	MathService mathService;    //Dependency Mocked
	
	@InjectMocks
	Calculator calculator;
	
	@Test
	void testAdd() {
		//Arrange
		when(mathService.add(10,20)).thenReturn(30);
		//Assert
		assertEquals(30, calculator.add(10,20));
		//Verify interaction
		verify(mathService).add(10,20);
	}
}
