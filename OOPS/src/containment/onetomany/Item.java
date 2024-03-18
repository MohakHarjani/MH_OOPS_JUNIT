package containment.onetomany;



public class Item {
	private int itemId;
	private String itemName;
	private double itemPrice;
	private Category itemCategory;
	//we need only shallow copy of itemCategory...
	//any changes done to category must be reflected in item also
	
	//===========================================================================================
	public Item(int itemId, String itemName, double itemPrice, Category itemCategory) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemCategory = itemCategory;
	}
	//===========================================================================================

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Category getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(Category itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemId() {
		return itemId;
	}
	//========================================================================================

	@Override
	public String toString() {
		return "ItemId = " + itemId + 
				", ItemName = " + itemName + 
				", ItemPrice =" + itemPrice + 
				", itemCategory : \n { " + itemCategory + " } \n\n";
	}
	@Override
	public int hashCode()
	{
		return this.itemCategory.getCategoryId();
	}
	public boolean equals(Object newItem)
	{
		return (this.itemId == ((Item)newItem).itemId);
	}
	
	

	
	

}
