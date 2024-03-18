package containment.onetomany;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Customer {
	private int customerId;
	private String customerName;
	private Set<Order>orders;
	static int orderId = 1;
	
	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.orders = new HashSet();
	}
	//====================================================================================================
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public int getCustomerId() {
		return customerId;
	}
	//===============================================================================================
	@Override
	public String toString() {
		return "CustomerId = " + customerId + 
				", CustomerName = " + customerName + 
				", Orders : \n { " + orders + " } \n\n";
	}
	//=============================================================================================
	
	Order bookOrder(Map<Item, Integer>mp)
	{
		Order newOrder =  new Order(Customer.orderId++, LocalDateTime.now(), mp);
		this.orders.add(newOrder);
		return newOrder;
	}
	
	double getTotal()
	{
		List<Map<Item, Integer>> mapList = this.orders.stream()
		                                              .map((Order o)->o.getItems())
		                                              .collect(Collectors.toList());
		double total = 0;
		for (Map<Item, Integer>mp : mapList)
		{
			for (Item i : mp.keySet())
			{
				int qty = mp.get(i);
				double price = i.getItemPrice();
				System.out.println(i.getItemName() + " = " + "Rs. " + i.getItemPrice() + " X " + qty);
				total += (price * qty);
			}
		}
		return total;
	}
	
	
	

}
