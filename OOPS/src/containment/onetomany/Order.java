package containment.onetomany;

import java.time.*;
import java.util.*;

public class Order {
	private int orderId;
	private LocalDateTime orderDateTime;
	private Map<Item, Integer>items;
	
	public Order(int orderId, LocalDateTime orderDateTime, Map<Item, Integer> items) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		
		this.items = new HashMap(items);  
		//copy of the passed map...deep copy
		//changes made to passed items won't be refelected in the private items
	}
	//=======================================================================================================
	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public Map<Item, Integer> getItems() {
		return items;
	}

	public void setItems(Map<Item, Integer> items) {
		this.items = items;
	}

	public int getOrderId() {
		return orderId;
	}
	//================================================================================================
	@Override
	public String toString() {
		return "OrderId = " + orderId + 
				", OrderDateTime = " + orderDateTime + 
				", Items : \n { " + items + " } \n\n";
	}

	
	
	

}
