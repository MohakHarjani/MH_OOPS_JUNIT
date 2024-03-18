package account;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;


public class AccountTest3_Paramterized {
	static Account acc;
	
	@BeforeAll
	static void initialize()
	{
		acc = new Account(104, "Mohak Harjani", 2000, "Savings");
	}
	//=====================================================================================================================
	
	
	//valueSource takes primitive types in an array as an argument
	//for double values we have to write "doubles"  [we cannot change the name :(]
	//similarly "ints", "chars", "floats", "strings"
	
	//same test runs 4 times for 4 different arguments
	@DisplayName("Value Source Test")
	@ParameterizedTest 
	@ValueSource(doubles = {1200, 500, 300, 100}) //consecutive withdrawals on same object..
	void testWithdraw1(double withdrawAmount)
	{
		try {  acc.withdraw(withdrawAmount);  }
		catch(Exception e) { System.out.println(e.getMessage()); }
		
		double foundBalance = acc.getAccBalance();
		assertTrue(foundBalance >= 0, "Withdraw function failed..balance got -ve");
	}
	//==================================================================================================================
	//{index} is an exact placeHolder toget index of each iteration
	//{arguments} is also an exact placeHolder to get argValue of each iteration
	
	@DisplayName("Value Source Test")
	@ParameterizedTest
	@ValueSource(doubles = {1200, 500, 1000, 300}) //each time a new Account obj is created inside the test
	//if you have only one arg to test, no need to wrap it to make an array ..doubles = 1200 ...works :)
	void testWithdraw2(double withdrawAmount)
	{
		acc = new Account(105, "Virat", 2000, "Current");
		
		try {  acc.withdraw(withdrawAmount);  }
		catch(Exception e) { System.out.println(e.getMessage()); }
		
		double foundBalance = acc.getAccBalance();
		double expectedBalance = 2000 - withdrawAmount;
		assertEquals(expectedBalance, foundBalance, "Withdraw function fails for amount < balance");
	}
	
	//==============================================================================================================
	//arguments will have 3 args as an array, but we want only first one arguments[0]"
//	@ParameterizedTest (name = "Test idx = {index}, argValue = {0}")
	@ParameterizedTest (name = "Test idx = {index}, argValue = {arguments}")
	@CsvFileSource (resources = "myData.csv", numLinesToSkip = 1) //we need to skip the first row (contains only fieldNames)
	void testWithdraw3(double prevBalance, double withdrawAmount, double expectedBalance)
	{
		acc = new Account(102, "Mohak", prevBalance, "Savings");
		assumeTrue(withdrawAmount >= 0, "WithdrawAmount < 0, test skipped");
		
		//will come here only if (withdrawAmount >= 0)'s assumption holds true
		try { acc.withdraw(withdrawAmount); }
		catch (Exception e) { System.out.println(e.getMessage()); }
		
		double foundBalance = acc.getAccBalance();
		assertEquals(expectedBalance, foundBalance);
	}
	
	//========================================================================================================================

	
}
