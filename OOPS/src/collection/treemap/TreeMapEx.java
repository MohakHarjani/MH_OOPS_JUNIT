package collection.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx {
	static void printMap(Map<String, Integer>mp)
	{
		mp.forEach((String k, Integer v)->{
			System.out.print("<" + k + ", " + v + ">   ");
		});
	}
	public static void main(String[] args)
	{
		TreeMap<String, Integer>mp = new TreeMap();
		
		//put will use the compareTo method of String
		// String class by default implements Comparable interface
		mp.put("Mohak", 5);
		mp.put("Kartik", 6);
		mp.put("Kshitij", 1);
		mp.put("Rakshit", 2);
		
		System.out.println(mp);
		
		int count = mp.get("Mohak");
		System.out.println(count);
		
		if (mp.containsKey(new String("Mohak")))
			System.out.println("Mohak found");
		
		for (String key : mp.keySet())
			System.out.print(key + ", ");
		System.out.println();
		
		//Will gives the values of sorted keys
		for (int value : mp.values())
			System.out.print(value + ", ");
		System.out.println();
		
		mp.forEach((String k, Integer v)->{
			System.out.print("<" + k + ", " + v + ">   ");
		});
		System.out.println();
		
		//============================================================================================
		//String class by default sorts the string lexicographically
		// But if I want to compare String object's differently...how can we do that
		// We cannot change the internal implementation of the compareTo method which is being overriden
		//   in the String class
		// We can then use "Comparator" interface 
		// TreeMap has a constructor which accepts "Comparator" type object as a parameter
		
		// Method - 1
		//  *Create a custom class which implements "Comaparator" (functional) interface
		//  *Then implement the "compare(Obj a, Obj b)' method
		//  *Then pass object/instance of that custom Class as a parameter while creating TreeMap
		
		// Method-2
		// *Create an anonymous class and it's ref using lambda function
		// *So directly write the code of compare method inside the lamda function
		// *Pass that function as param while creating TreeMap
		
		Comparator<String> cc = new CustomCompare();
		TreeMap<String, Integer>mp2 = new TreeMap<>(cc); //This stored based on length of string
		mp2.put("Mohaaaa", 5);
		mp2.put("Kart", 6);
		mp2.put("Kshitijaaaa", 1);
		mp2.put("Rakit", 2);
		printMap(mp2);
		
		
		
		
		
		
	}

}
