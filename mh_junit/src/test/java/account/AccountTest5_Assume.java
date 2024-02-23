package account;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.*;


public class AccountTest5_Assume {
	static Account acc;
	@BeforeAll
	static void init()
	{
		acc = new Account(103, "Mohak", 1000, "Savings");
	}
	
	//Skipping the whole test
	@Test
	@DisplayName("This test runs only on Sunday...else aborted/skipped")
	void sundayTest()
	{
		LocalDateTime currDt = LocalDateTime.now();
		int dayIdx = currDt.getDayOfWeek().getValue();
		assumeTrue(dayIdx == 7, "Test skipped as today is not Sunday");
		
		//will come here only if the above condition is "true"
		//else the test will be "Skipped"
		
		assertEquals("Mohak".length() , 5);
	}
	
	//=====================================================================================
	
	//If we want to skip only a specific part of code based on some condition
	//And we don't want to "skip/abort" the test and continue moving then we use
	//assumingThat
	//The handler will run if condition holds true
	//The following code will run irrespective of condition returning true/false
	
	@Test
	void taxTest()
	{
		//even if balance is 1000....the test won't skip
		//if bal > 2000 and the code inside handler fails, the only test will fail
		assumingThat(acc.getAccBalance() > 2000, ()->{
			boolean taxPayed = true;
			assertTrue(taxPayed, "Tax not payed :(......");
		});
		
		//the following code will "always" run
		assertEquals("Mohak".length() , 5);
	}
	
	//============================================================================================
	
	@Test
	void falseTest()
	{
		assumeFalse(9 < 4); //the following code will run only if condition inside it is false
		assertEquals(5 + 3, 4 + 4);
	}
	

}
