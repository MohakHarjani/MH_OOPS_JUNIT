package collection.hashmap;

import java.util.*;
import java.util.function.BiConsumer;

public class HashMapEx {
	public static void main(String[] args)
	{
		HashMap<Integer, String> mp = new HashMap<Integer, String>();
		//Hashes the key...adds the <Key, Val> pair in the corresponding hashBucket
		//So here "HashCode() of Integer" class will be called, as key is of Integer class
		//similarly "equals() of Integer" will be called, as key's are compared and key is of Integer class
		
		mp.put(1, "Mohak");
		mp.put(7, "Kartik");
		mp.put(8, "Kshitj");
		mp.put(13, "Rakshit");
		
		System.out.println(mp);
		
		mp.put(1, "Mohak Harjani"); //Overwrites the value
		
		System.out.println(mp);
 
		System.out.println(mp.get(8));
		
		//============================================================================================
		//keySet() returns a set, as keys are unique in a HashMap
		for (int key : mp.keySet())
			System.out.print(key + ", ");
		System.out.println();
		
		Set<Integer>keys = mp.keySet();
		keys.forEach((Integer key)->{ System.out.print(key + ", "); }); 
		System.out.println();
		
		//=============================================================================================
		//values return a list as many keys can have same values (can have duplicates
		for (String value : mp.values())
			System.out.print(value + ", ");
		System.out.println();
		
		Collection<String>values = mp.values();
		values.forEach((String value)->{ System.out.print(value + ", "); }); 
		System.out.println();
		
		//=================================================================================================
		BiConsumer<Integer, String> bc = (Integer k, String v)->{ System.out.print("<" + k + ", " + v + ">  ") ;};
		mp.forEach(bc);
		
		
		HashMap<String, Integer>mp2 = new HashMap();
		mp2.put("Mohak",1);
	}

}
