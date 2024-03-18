package containment.onetomany;

import java.util.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Category c1 = new Category(1, "Clothing", "Clothes made in India");
		Category c2 = new Category(2, "Electronics", "Electronic products made in India");

		//==========================================================================================
		Item it1 = new Item(1, "T-Shirt", 500.0, c1);
		Item it2 = new Item(2, "Jacket", 800.0, c1);
		Item it3 = new Item(3, "Socks", 100.0, c1);
		Item it4 = new Item(4, "Samung M14", 14000.0, c2);
		Item it5 = new Item(5, "Realem 3i", 10000.0, c2);
		//==============================================================================================
		Map<Item, Integer>itemMap1 = new HashMap<Item, Integer>();
		itemMap1.put(it1, 2); 
		itemMap1.put(it3, 4);
		itemMap1.put(it4, 1); 
		itemMap1.put(new Item(1, "T-Shirt", 500.0, c1),  3); //overwriting the quantity
		
		Map<Item, Integer>itemMap2 = new HashMap<Item, Integer>();
		itemMap2.put(it2, 3); 
		itemMap2.put(it2, 1);
		itemMap2.put(it5, 2); 
		itemMap2.put(new Item(4, "Samung M14", 14000.0, c2),  1); 
		//===================================================================================================
		
		Customer mohak = new Customer(1, "Mohak");
		Customer virat = new Customer(2, "Virat");
		
		mohak.bookOrder(itemMap1);
//		mohak.bookOrder(itemMap1); //SET WON'T WORK, HASHCODE MEI KYA RAKHU NO IDEA
		mohak.bookOrder(itemMap2);
		
		virat.bookOrder(itemMap1);
		
		itemMap1.put(it3, 10000);  //no effect on actual order
		c1.setCategoryDesc("Clothes are made in Bharat"); //this change will be reflected 
		System.out.println(mohak);
		System.out.println("//=================================================================");
		System.out.println(virat);
		
		
		//======================================================================================================
		
		double mohakTotal = mohak.getTotal();
		System.out.println(mohak.getCustomerName() + " spent " + mohakTotal);
		System.out.println("//=================================================================");
		double viratTotal = virat.getTotal();
		System.out.println(virat.getCustomerName() + " spent " + viratTotal);
		
	
		
		
		

		

	}

}
