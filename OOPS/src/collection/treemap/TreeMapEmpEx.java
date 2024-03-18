package collection.treemap;
import java.util.*;

import collection.Employee;
import collection.Manager;

public class TreeMapEmpEx {
	static void printMap(Map<Employee, Manager>mp)
	{
		mp.forEach((Employee e, Manager m)->{
			System.out.print("Employee name = " + e.getEmpName() + ", id = " + e.getEmpId() + "===>"); 
			System.out.println("Manager name = " + m.getEmpName());
		});
		System.out.println();
	}

	public static void main(String[] args)
	{
		TreeMap<Employee, Manager>mp = new TreeMap();
		
		Employee e1 = new Employee(1,"Mohak",50000.0,10);
		Employee e2 = new Employee(3, "Radha", 70000.0, 20);
		Employee e3 = new Employee(2,"Kartik",60000.0,10);
		Employee e4 = new Employee(4,"Mita",60000.0,20);
		Employee e5 = new Employee(9,"Geeta",70000.0,20);
		Employee e6 = new Employee(11,"Seeta",80000.0,30);
		
	    Manager m1 = new Manager(13,"Keeta",90000,30,5,5000,50000);
	    Manager m2 = new Manager(15,"Arun",100000,100,5,5000,50000);
	    Manager m3 = new Manager(18,"Rahul",100000,20,5,5000,50000);
	    
	    // When Comparable interface is not implemented in Employee
	    //This gives ClassCast Exception
	    //Because Employee class doesn't implement "Comparable" interface
	    //Internally "TreeMap.put()" assumes that the class would implement "Comparable" 
	    //    and thus tries to call "compareTo()" method on Employee class
	    // something like this (Comparable)empObj.compareTo(empObj2) would be called
	    // But empObj does not implement "Comparable" 
	    // and empObj does not hold a "IS-A" relationship with "Comparable"
	    //Thus it gives a ClassCast Exception
	    
	    
	    //map based on ascending empId
	    mp.put(e1,  m2);
	    mp.put(e2, m1);
	    mp.put(e3,  m1);
	    mp.put(e4,  m3);
	    mp.put(e5,  m1);
	    mp.put(e6,  m1);
	    mp.put(e6,  m1);
	    printMap(mp);
	    System.out.println();
	    
	    
	    
	    //Map based on decreasing empId
	    TreeMap<Employee, Manager>mp2 = new TreeMap<>((Employee a, Employee b)->{
	    	if (a.getEmpId() > b.getEmpId())
	    		return -1;
	    	else if (a.getEmpId() < b.getEmpId())
	    		return +1;
	    	else
	    		return 0;
	    });
	    mp2.put(e1,  m2);
	    mp2.put(e2, m1);
	    mp2.put(e3,  m1);
	    mp2.put(e4,  m3);
	    mp2.put(e5,  m1);
	    mp2.put(e6,  m1);
	    mp2.put(e6,  m1);
	    
	    if (mp.containsKey(new Employee(1,"Mohak",50000.0,10)))
	    {
	    	System.out.println("Mohak found");
	    }
	    printMap(mp2);

		
	}
}
