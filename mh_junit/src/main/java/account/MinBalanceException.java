package account;

public class MinBalanceException extends Exception{
	private int accId;
	private String accHolderName;
	private double accBalance;
	
	public MinBalanceException(int accId, String accHolderName, double accBalance)
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
