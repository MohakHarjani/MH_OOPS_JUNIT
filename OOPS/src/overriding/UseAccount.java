package overriding;
public class UseAccount {

	public static void main(String[] args) {
		
		Account acc1 = new Account();
		System.out.println("Account - 1 => " + acc1);
		System.out.println("//==================================================================================================");
		
		Account acc2 = new Account(1234, "Mohak Harjani", 20000, "Savings");
		System.out.println("Account - 2 => " + acc2);
		//==========================================================================
		System.out.println("Account Holder Name Before = " + acc2.getAccHolderName());
		acc2.setAccHolderName(null);
		System.out.println("Account Holder Name After = " + acc2.getAccHolderName());
		//===============================================================================
		System.out.println("Account Holder Name Before = " + acc2.getAccHolderName());
		acc2.setAccHolderName("Mohak Kumar");
		System.out.println("Account Holder Name After = " + acc2.getAccHolderName());
		//=========================================================================
		System.out.println("Account Balance Before = " + acc2.getAccBalance());
		acc2.setAccBalance(-100);
		System.out.println("Account Holder Name After = " + acc2.getAccBalance());
		//==============================================================================
		System.out.println("Account Balance Before = " + acc2.getAccBalance());
		acc2.setAccBalance(400);
		System.out.println("Account Holder Name After = " + acc2.getAccBalance());
	
		System.out.println("//==================================================================================================");
		Account acc3 = new Account(1980, "Sudhir Harjani", 70000, "Current");
		System.out.println("Account - 3 => " + acc3);
		
		System.out.println("Account Balance Before = " + acc3.getAccBalance());
		acc3.withdraw(70000);
		System.out.println("Account Holder Balance After = " + acc3.getAccBalance());
		
		System.out.println("Account Balance Before = " + acc3.getAccBalance());
		acc3.withdraw(90);
		System.out.println("Account Holder Balance After = " + acc3.getAccBalance());
	
		

	}

}