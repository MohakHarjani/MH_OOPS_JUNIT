package containment.onetomany;

public class Category {
	private int categoryId;
	private String categoryName;
	private String categoryDesc;
	
	public Category(int categoryId, String categoryName, String categoryDesc) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
	}
	//========================================================================================
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public int getCategoryId() {
		return categoryId;
	}
	//===========================================================================================
	@Override
	public String toString() {
		return "CategoryId = " + categoryId +
			   ", CategoryName = " + categoryName + 
			   ", CategoryDesc = " + categoryDesc + " ";
	}
	
	
	
	

}
