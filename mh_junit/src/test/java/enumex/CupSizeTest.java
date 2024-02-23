package enumex;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.params.provider.EnumSource.Mode.*;

public class CupSizeTest {
	
	//check whether each value inside CupSize is not null
	@ParameterizedTest
	@EnumSource (value = CupSize.class)
	void testNotNull(CupSize cup)
	{
		assertNotNull(cup);
	}
	
	//====================================================================================
	
	//check whether the given Strings are present as values/names inside Enum or not
	//What it will internally do is....
	//It will make a EnumSet of CupSize values, extract only the "name" part of each value 
	//then it stores all the "names"(String) of enumValues in a set
	//then it will check one by one the values passed as names in Params of @EnumSource
	//and check if it is present in the Set<String>of names of enumValues
	//default mode is INCLUDE..it will pass only those names to test which are present in CupSize
	@ParameterizedTest (name = "Test-idx = {index} , argValue = {arguments}")
	@EnumSource (value = CupSize.class, names = {"SMALL", "MEDIUM"})
	void testContains(CupSize cup)
	{
		//if the string specified inside names are not valid names from enumSource
		//it will give error
		
		//the test will be executing only if the values are valid....
		//in this we are just simulating the contains behaviour...but it's redundant
	
		EnumSet<CupSize> cupSet = EnumSet.allOf(CupSize.class);
		assertTrue(cupSet.contains(cup)); //this wil never be false....varna error hi ajata phle hi
	}
	
	//========================================================================================
	
	//here mode = EXCLUDE, it will pass only those names which are not mentioned in names 
	@ParameterizedTest
	@EnumSource(value = CupSize.class, mode = EXCLUDE, names = {"SMALL", "MEDIUM"})  //import EXCLUDE
	void testContains1(CupSize cup)
	{
		
		//another way of creating an enumSet
		EnumSet<CupSize>cupSet = EnumSet.range(CupSize.SMALL, CupSize.EXTRALARGE);
		assertTrue(cupSet.contains(cup));
	}
	
	//==========================================================================================
	//add a test to check all enum cup prices are divisible by 5
	
	@ParameterizedTest
	@EnumSource(CupSize.class)
	void testDivisible(CupSize cup)
	{
		assertTrue(cup.getPrice() % 5 == 0);
	}
	
	
	//==========================================================================================
	//check that all cup sizes that are type/pattern LARGE have prices more than 20 rs
	
	@ParameterizedTest 
	@EnumSource(value = CupSize.class, mode = MATCH_ANY, names = ".+LARGE")
	void testLarge(CupSize cup)
	{
		assertTrue(cup.getPrice() > 20);
	}
	
	//========================================================================================
	
	@Test
	void checkGap()
	{
		CupSize[] cps = CupSize.values();
		int[] prices = new int[cps.length];
		for (int i = 0; i < cps.length; i++)
		{
			prices[i] = cps[i].getPrice();
			System.out.println(prices[i]);
		}

		boolean p = true;
		for (int i = 1; i < prices.length; i++)
		{
			if (prices[i] - prices[i - 1] != 10)
			{
				p = false;
				break;
			}
		}
    	assertTrue(p);
	}
	
	//=======================================================================================
	

}
