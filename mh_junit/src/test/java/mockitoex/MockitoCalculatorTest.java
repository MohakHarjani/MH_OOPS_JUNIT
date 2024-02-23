package mockitoex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import calculator.Calculator;

@ExtendWith(MockitoExtension.class)
public class MockitoCalculatorTest {
	
	@Mock
	Calculator mockCalc;
	
	@Spy
	Calculator spyCalc = new Calculator(3, 4);
	
	@Captor
    ArgumentCaptor<Double> argCaptor;
	
	
//	Calculator spyCalc = Mockito.spy(Calculator.class);
	
	@Test
	void testMock()
	{
		double sum = mockCalc.add();
	//	System.out.println(sum);  //return 0.0
		verify(mockCalc).add();
		assertEquals(0.0, sum);
		
		when(mockCalc.add()).thenReturn(7.0);
		
		double found = mockCalc.add();
		assertEquals(7.0, found);
		
	}
	//=======================================================================================
	@Test
	void testSpy()
	{
		double sum = spyCalc.add();
		verify(spyCalc).add();
		assertEquals(7.0, sum);
		
		when(spyCalc.add()).thenReturn(9.0);
		sum = spyCalc.add();
		assertEquals(9.0, sum);
		
		doReturn(15.00).when(spyCalc).mul();
		double prod = spyCalc.mul();
		assertEquals(15.0, prod);
	}
	//====================================================================================
	@Test
	void testCapture()  //same for mock spy
	{
		mockCalc.setOp1(10);
		verify(mockCalc).setOp1(argCaptor.capture());   //will not work for multiple calls on setOp1

		assertEquals(10, argCaptor.getValue());
		
		
		mockCalc.setOp2(11);
		mockCalc.setOp2(11);
		verify(mockCalc, times(2)).setOp2(11); //checks whether setOp1 was called for 2 times
		//if less or more, it will fail the test
		
		mockCalc.setOp2(12);
		verify(mockCalc, times(3)).setOp2(argCaptor.capture());
		double lastPassed = argCaptor.getValue();  //gives the last captured value
		//.getValues() will return list of all captured values [10.0, 11.0, 11.0, 12.0]
		
		assertEquals(12, lastPassed);
	}
	//==================================================================================
}
