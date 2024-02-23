package enumex;

public enum CupSize {
	
	//each variable/enum val inside will be of type "CupSize"
	SMALL(10),  //() will internally call the constructor
	MEDIUM(20),
	LARGE(30),
	EXTRALARGE(40);
	
	private int price;  //internal variable
	CupSize(int price)  //internal  constructor
	{
		this.price = price;
	}
	
	public int getPrice()
	{
		return this.price;
	}
}
