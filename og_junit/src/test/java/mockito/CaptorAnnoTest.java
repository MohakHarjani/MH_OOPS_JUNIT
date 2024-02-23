package mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
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
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
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
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class CaptorAnnoTest {

	@Mock
	HashMap<String, Integer> myMap;
	
	@Captor
	ArgumentCaptor<String> keyCaptor;
	@Captor
	ArgumentCaptor<Integer> valueCaptor;
	
	@BeforeAll
	public void init() {
	    MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void ArgumentCaptorTest()
	{
		//HashMap<String ,Integer> myMap = mock(HashMap.class);
		//when(myMap.put("A", 10)).thenReturn(10);
		myMap.put("A", 10);
		assertEquals(0, myMap.size());
		
		verify(myMap).put(keyCaptor.capture(),valueCaptor.capture());
		assertEquals("A", keyCaptor.getValue());
	    assertEquals(10, valueCaptor.getValue());
	}
	
	@Test
	void test() {

	
	}
}