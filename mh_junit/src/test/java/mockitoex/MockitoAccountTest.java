package mockitoex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import account.Account;
import account.InsufficientBalanceException;
import account.MinBalanceException;

@ExtendWith(MockitoExtension.class)
public class MockitoAccountTest {
	
	@Mock
	Account mockAcc;
	
	@Spy
	Account spyAcc = new Account(104, "Mohak", 2000, "Savings");
	
	@Captor
	ArgumentCaptor<Double>argCaptor;
	
	
	@Test
	void testMock() throws InsufficientBalanceException, MinBalanceException
	{
		double balance = -1;
				
		balance = mockAcc.withdraw(200); 
		//System.out.println(balance); //balance will be 0.0, as mockAcc is fake
		assertEquals(0.0, balance);
		
		when(mockAcc.withdraw(200)).thenReturn(1800.00);
		assertEquals(1800, mockAcc.withdraw(200));
		
		mockAcc.withdraw(400);
		verify(mockAcc, times(3)).withdraw(argCaptor.capture());
		assertEquals(400, argCaptor.getValue());
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {1000, 500, 1500, 400})
	void testSpy(double withdrawAmount) throws InsufficientBalanceException, MinBalanceException
	{
		
		double balance = spyAcc.withdraw(withdrawAmount);
		
		assertEquals(2000.0 - withdrawAmount, balance);
		
		verify(spyAcc).withdraw(argCaptor.capture());
		assertEquals(withdrawAmount, argCaptor.getValue());
	}
	
	
	

}
