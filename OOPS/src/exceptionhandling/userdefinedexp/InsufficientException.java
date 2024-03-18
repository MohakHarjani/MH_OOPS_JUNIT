package exceptionhandling.userdefinedexp;

public class InsufficientException extends Exception{
	private int accId;
	private String accHolderName;
	private double accBalance;
	
	public InsufficientException(int accId, String accHolderName, double accBalance)
	{
		this.accId = accId;
		this.accHolderName = accHolderName;
		this.accBalance = accBalance;
	}

	@Override
	public String getMessage() {
		
		return "Account with accId = " + accId + ", accHolderName = " + accHolderName 
				+ ", accBalance = " + accBalance  + " has insufficient balance ";
		
	}

}
