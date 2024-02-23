package account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//2000 => (Dep)+1500 => (draw < bal)-1000 =>  (draw <= bal) -{0, 2000, 500} => draw > bal -{100}
@TestMethodOrder(OrderAnnotation.class)   //This is required
public class AccountTest4_Order {
	
	static Account acc;
	
	
	@BeforeAll
	static void initialize()
	{
		acc = new Account(104, "Mohak Harjani", 2000, "Savings");
	}
	
	//=================================================================================
	
	@ParameterizedTest
	@Order(4)
	@ValueSource(doubles = {100})
	void testGreaterWithdraw(double withdrawAmount)
	{
		assertThrows(InsufficientBalanceException.class, ()->{
			
			acc.withdraw(withdrawAmount);
			
		});
	}

	//======================================================================================
	
	@Order(3)
	@ParameterizedTest (name = "Test-idx = {index} , withdrawAmount = {arguments}")
	@ValueSource(doubles = {0, 2000, 500})
	void testMultipleWithdraws(double withdrawAmount)
	{
		try { acc.withdraw(withdrawAmount); }
		catch (Exception e) { System.out.println(e.getMessage()); }
		
		assertTrue(acc.getAccBalance() >= 0);
	}

	
	//========================================================================================
	
	@ParameterizedTest
	@Order(1)
	@ValueSource (doubles = 1500)
	void depositTest(double depositAmount)
	{
		acc.deposit(depositAmount);
		double expectedBalance = 3500;
		double foundBalance = acc.getAccBalance();
		assertEquals(expectedBalance, foundBalance);
	}
	

	
	//========================================================================================
	
	@Order(2)
	@Test
	void testLesserWithdraw()
	{
		try { acc.withdraw(1000); }
		catch (Exception e) { System.out.println(e.getMessage()); }
		
		double expectedBalance = 2500;
		double foundBalance = acc.getAccBalance();
		assertEquals(expectedBalance, foundBalance);
	}
	
	
	//============================================================================================
	
	

}
