package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculatorTest {
	
	static Calculator calc;
	
	@BeforeAll
	static void initialize()
	{
		calc = new Calculator(20, 30); 
		//this object will be created only once
		//this will be the default obj used when obj is not setted inside specific test
	}
	
	@DisplayName("Add Test")
	@Test
	void testAdd()
	{
		//using the static object
		double found = calc.add();
		double expected = 50;
		assertEquals(expected, found, "Add not working..");
	}
	

	@DisplayName("Subtract Test")
	@Test
	void testSub()
	{
		calc.setOp1(20); 
		calc.setOp2(40);   //using diff values for different tests
		double found = calc.sub();
		double expected = -20;
		assertEquals(expected, found, "Subtract not working..");
	}
	
	@DisplayName("Multipy Test")
	@Test
	void testMul()
	{
		calc.setOp1(2); 
		calc.setOp2(-1);   
		double found = calc.mul();
		double expected = -2;
		assertEquals(expected, found, "Multiply not working..");
	}
	
	@DisplayName("Double Divide Test")
	@Test
	void testDoubleDiv()  //double divide by 0 return "infinity"
	{
		calc.setOp1(2); 
		calc.setOp2(0);   
		double found = calc.doubleDiv();
		double expected = Double.POSITIVE_INFINITY;
//		assertEquals(expected, found, "Multiply not working..");
		assertTrue(Double.isInfinite(found), "Double Divide not working..");
		
	}
	
	@DisplayName("Divide Test")
	@Test
	void testIntDiv()   //int divide by 0 throws arithmetic exception
	{
		calc.setOp1(2); 
		calc.setOp2(0);   
		
		assertThrows(ArithmeticException.class, ()->{
			calc.intDiv();
			
		}, "Integer Divide not working..");
		
	}
	
	

}
