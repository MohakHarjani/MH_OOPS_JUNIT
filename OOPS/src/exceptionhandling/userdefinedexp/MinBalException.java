package exceptionhandling.userdefinedexp;

public class MinBalException extends Exception{
	private int accId;
	private String accHolderName;
	private double accBalance;
	
	public MinBalException(int accId, String accHolderName, double accBalance)
	{
		this.accId = accId;
		this.accHolderName = accHolderName;
		this.accBalance = accBalance;
	}

	@Override
	public String getMessage() {
		
		return "Account with accId = " + accId + ", accHolderName = " + accHolderName 
				+ ", accBalance = " + accBalance  + " doesn't have minimum balance ";
		
	}

}
