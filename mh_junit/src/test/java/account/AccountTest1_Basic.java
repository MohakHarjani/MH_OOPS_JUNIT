package account;

import static org.junit.jupiter.api.Assertions.*; //importing all static methods of Assertions class
import org.junit.jupiter.api.*;


//Junit will create an instance of this class
//for annotations on method it will get class instance using .class or getClass
//then using Class object it will get methods
//using those method instances it will call method.getAnnotations
//then will extract values/params of annotations if required
//then it will run the corrsponding code
public class AccountTest1_Basic {
	
	@BeforeAll    //beforeAll and AfterAll ...suffixed as "All" needs to be static
	static void beforeAll()
	{
		System.out.println("This runs before all tests...\n");
	}
	
	@BeforeEach
	void beforeEach()
	{
		System.out.println("This runs before each test ...");
	}
	//========================================================================
	
	//These tests might run in any order.....No specific order...............
	@DisplayName("Test-1")
	@Test
	void basicTest1()
	{
		System.out.println("Test-1 running");
		assertTrue(true);
	}
	@DisplayName("Test-2")
	@Test
	void basicTest2()
	{
		System.out.println("Test-2 running");
		assertTrue(true);
	}
	@DisplayName("Test-3")
	@Test
	void basicTest3()
	{
		
		System.out.println("Test-3 running");
		assertTrue(true);
	}
	//=================================================================================
	@AfterEach
	void afterEach()
	{
		System.out.println("This runs after each test ... \n");
		
	}
	
	@AfterAll
	static void afterAll()
	{
		System.out.println("This runs after each test ... \n");
		
	}
	//==========================================================================================
}
