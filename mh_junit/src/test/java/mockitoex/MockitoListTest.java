package mockitoex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class) 

public class MockitoListTest {
	
	//Mocks are completely fake objects created from the class definition, not actual instances
	//they have no pre-existing behaviour...
	//the mehod only return default values
	//eg if fun() method returns int by definition...mock will return 0 for every call (execpt stubs)
	// if return type is Object, it will always return null...
	@Mock
	List<String>mockList;
	
	
	//Spies are wrappers around existing objects. 
	//They retain the original behavior of the object 
	//while allowing you to monitor and potentially stub specific methods.
	//@Spy doesn't work for inbuilt classes in Java-17 :(...working for custom classes :)
//	@Spy
//	 List<String>spyList = new ArrayList<String>();
	
	List<String>spyList = Mockito.spy(ArrayList.class);
	
	//============================================================================================
	@Test
	void testMock()
	{
		mockList.add("Mohak");   //fake behaviour...nothing is added actually
		mockList.add("Virat");
		
		//verify helps to check that whether previous calls made were "actually made" or not
		//to confirm whether add("Mohak") was called or not
    	verify(mockList).add("Mohak");  //not for making a new call
    	
		//System.out.println(mockList.size()); //this will return 0
		
		assertEquals(0, mockList.size());
	}
	//===========================================================================================
	@Test
	void testSpy()
	{
 		spyList.add("Mohak"); //this will invoke the actual methods if not stubbed
 		spyList.add("Virat");
 		verify(spyList).add("Mohak");
		
        
	//	System.out.println(spyList.size()); /returns 2
 		assertEquals(2, spyList.size());
	}
	//==========================================================================================
	@Test
	void testMockStub()
	{
		mockList.add("Mohak");
		mockList.add("Kartik");
		mockList.add("Virat");
		
		when(mockList.size()).thenReturn(3); //stubbing

	//	System.out.println(mockList.size()); //returns 3
		assertEquals(3, mockList.size());
		
		when(mockList.get(100)).thenReturn("Sachin");  //stubbing
		assertEquals(mockList.get(100), "Sachin");
	}
	//==========================================================================================
	
	@Test
	void testSpyStub()
	{
		spyList.add("Mohak");
		spyList.add("Kartik");
		spyList.add("Virat");
		
		when(spyList.size()).thenReturn(3); //stub...Method-1
		
		spyList.add("Sachin");  //added the 4th string
		
		//System.out.println(spyList.size()); //3 .. due to stubbing default behaviour is overriden
		
		assertEquals(3, spyList.size());
		
		doReturn("Rahul").when(spyList).get(100);  //this should be always used for stubbing..Method-2
		
		assertEquals("Rahul", spyList.get(100));
		
		
	}
	

}
