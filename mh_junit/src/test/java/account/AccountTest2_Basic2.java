package account;

import static org.junit.jupiter.api.Assertions.*;  //all static var's, methods of Assertions class

import org.junit.jupiter.api.*;

public class AccountTest2_Basic2 {
	
	Account acc; //create the ref variable global and not inside beforeEach...so that it is accessible in every test
	
	@BeforeEach
	void initialize()
	{
		//before every test we will have the obj with balance 2000
		acc = new Account(104, "Mohak Harjani", 2000, "Savings");
	
		
	}
	//=======================================================================================
	//for each condition of each method in account, generate a test function
	@DisplayName("DepositAmount >= 0")
	@Test
	void testDeposit()
	{
		acc.deposit(100);
		double foundBalance = acc.getAccBalance();
		double expectedBalance = 2100;
		
		//technically order won't matter...but expected-first, found-second (convention)
		assertEquals(expectedBalance, foundBalance, "Deposit not working for depositAmount >= 0");
	
	}
	
	@DisplayName ("DepositAmount < 0")
	@Test
	void testNegativeDeposit()
	{
		acc.deposit(-1000);
		double foundBalance = acc.getAccBalance();
		double expectedBalance = 2000;
		
		assertEquals(expectedBalance, foundBalance, "Deposit not working for depositAmount < 0");
	}
	
	@DisplayName ("withdrawAmount < Balance")
	@Test
	void testLesserWithdraw()
	{
		try {   acc.withdraw(1800.01);   } 
		catch(Exception e) {   System.out.print(e.getMessage()); }
		
		double foundBalance = acc.getAccBalance();
		double expectedBalance = 199.99;
		
		System.out.println(foundBalance + ", " + expectedBalance);
		
		assertEquals(expectedBalance, foundBalance, "Withdraw not working for withdrawAmount < balance");
		
	}
	
	@DisplayName ("withdrawAmount == Balance")
	@Test
	void testEqualWithdraw()
	{
		try {   acc.withdraw(2000.00);   } 
		catch(Exception e) {   System.out.print(e.getMessage()); }
		
		double foundBalance = acc.getAccBalance();
		double expectedBalance = 0;
		
		assertEquals(expectedBalance, foundBalance, "Withdraw not working for withdrawAmount = balance");
		
	}
	
	@DisplayName("WithdrawAmount > Balance")
	@Test
	void testGreaterWithdraw()
	{
		assertThrows(InsufficientBalanceException.class, ()->{
			acc.withdraw(3000);
		}, "Withdraw not working for withdrawAmount > balance");
		
	}
	
//	@DisplayName("Balance < 1000")
//	@Test
//	void testMinBalanceWithdraw()
//	{
//		acc.setAccBalance(800);
//		assertThrows(MinBalanceException.class, ()->{
//			acc.withdraw(300);
//		}, "Withdraw not working for balance < 1000");
//	}
}
