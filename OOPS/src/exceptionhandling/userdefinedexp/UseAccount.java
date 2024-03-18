package exceptionhandling.userdefinedexp;

import java.util.*;


public class UseAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc = new Account(1234, "Mohak Harjani", 20000, "Savings");
		String input = "y";
		Scanner sc = new Scanner(System.in);
		while(input.toLowerCase().charAt(0) == 'y')
		{
			System.out.print("Enter the withdrawal amount ");
			double amount = sc.nextDouble();
			
			try
			{
			  acc.withdraw(amount);
			}
			catch(InsufficientException e)
			{
				System.out.println(e.getMessage());
			}
			catch(MinBalException e)
			{
				System.out.println(e.getMessage());
				break;
			}

			System.out.print("Want to withdraw more ? (y/n) ");
			input = sc.next();
		}
		System.out.println("Withdrawal process ended");

	}

}
