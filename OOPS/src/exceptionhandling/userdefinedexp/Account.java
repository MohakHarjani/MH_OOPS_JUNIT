package exceptionhandling.userdefinedexp;

public class Account {
	private int accId;
	private String accHolderName;
	private double accBalance;
	private String accType;
	//====================================================================================
	//CONSTRUCTORS
	Account()
	{ System.out.println(" No parameter constructor called : "); }
	
	public Account(int accId, String accHolderName, double accBalance, String accType)
	{
//		System.out.println("Parameterized constructor called : ");
		this.accId = accId;
		this.accHolderName = accHolderName;
		this.accBalance = accBalance;
		this.accType = accType;
	}

	//============================================================================================
	//GETTERS AND SETTERS
	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		if (accHolderName == "" || accHolderName == null)
		{
			System.out.println("Name cannot be empty");
			return;
		}
		this.accHolderName = accHolderName;
	}

	public double getAccBalance() {
		return accBalance;
	}
	

	public void setAccBalance(double accBalance) {
		if (accBalance < 0)
		{
			System.out.println("Account Balance cannot be negative :( ");
			return;
		}
		this.accBalance = accBalance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		if (accType != "Savings" && accType != "Current")
		{
			System.out.println("Invalid Account type ");
			return;
		}
		this.accType = accType;
	}
	public int getAccId() {
		return accId;
	}
	//======================================================================================
	//INSTANCE METHODS
	public String toString()
	{
		return "accId : " + this.accId  +
				", accHolderName : " + this.accHolderName + 
				", accBalance : " + this.accBalance + 
				", accType : " + this.accType;
	}
	double deposit(int depositAmount)
	{
		this.accBalance += depositAmount;
		return this.accBalance;
	}
	double withdraw(double withdrawAmount) throws InsufficientException, MinBalException
	{
		if (this.accBalance < 1000)
		{
			throw new MinBalException(this.accId, this.accHolderName, this.accBalance);
		}
		else if (withdrawAmount > this.accBalance)
		{
			throw new InsufficientException(this.accId, this.accHolderName, this.accBalance);
		}
		else
		{
			this.accBalance = this.accBalance -  withdrawAmount;
			System.out.println("Balance after withdrawl = " + this.accBalance);
		}
		
		return this.accBalance;
	}
	//============================================================================================
}



