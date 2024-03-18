package collection.hashmap;

import java.util.*;

import collection.Employee;
import collection.Manager;

public class HashMapEmpEx {
	public static void main(String[] args)
	{
		Employee e1 = new Employee(1,"Mohak",50000.0,10);
		Employee e2 = new Employee(3, "Radha", 70000.0, 20);
		Employee e3 = new Employee(2,"Kartik",60000.0,10);
		Employee e4 = new Employee(4,"Mita",60000.0,20);
		Employee e5 = new Employee(9,"Geeta",70000.0,20);
		Employee e6 = new Employee(11,"Seeta",80000.0,30);
		

	    Manager m1 = new Manager(13,"Keeta",90000,30,5,5000,50000);
	    Manager m2 = new Manager(15,"Arun",100000,100,5,5000,50000);
	    Manager m3 = new Manager(18,"Rahul",100000,20,5,5000,50000);
	    
	    HashMap<Employee, Manager> mp = new HashMap();
	    
	    mp.put(e1, m3); System.out.println();
	    mp.put(e2, m3); System.out.println();
	    mp.put(e3, m1); System.out.println();
	    mp.put(e4, m2); System.out.println();
	    mp.put(e5, m2); System.out.println();
	    mp.put(e6, m3); System.out.println();
	    
	    System.out.println("//===============================================================================");
	    Employee e7 = new Employee(3, "Radha", 70000.0, 20);
		Employee e8 = new Employee(2,"Kartik",60000.0,10);
		Employee e9 = new Employee(9, "Geeta", 70000.0, 20);
		
	    //Overwrting the value on same keys
	    mp.put(e7, m1); System.out.println();
	    mp.put(e9, m3); System.out.println();
	    mp.put(e8, m3); System.out.println();
	    
//	    System.out.println(mp);
	    System.out.println("//=====================================================================================");
	    
	    
	    Manager foundManager = mp.get(new Employee(1,"Mohak",50000.0,10));
	    if (foundManager != null)
	    	System.out.println("Employee with id = 1 has a manager = " + foundManager.getEmpName());
	    else
	    	System.out.println("Employee with id = 1 not found");
	    System.out.println("//=====================================================================================");

	    
	    foundManager = mp.get(new Employee(41, "Geeta", 70000.0, 20));
	    if (foundManager != null)
	    	System.out.println("Employee with id = 41 has a manager = " + foundManager.getEmpName());
	    else
	    	System.out.println("Employee with id = 41 not found");
	    
	    System.out.println("//=====================================================================================");
	
	}

}
