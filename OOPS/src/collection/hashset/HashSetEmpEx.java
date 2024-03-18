package collection.hashset;
import java.util.*;

import collection.Employee;
public class HashSetEmpEx {

	public static void main(String[] args) {
		
		HashSet<Employee> s = new HashSet<Employee>();
	 	
		Employee e1 = new Employee(1,"Mohak",50000.0,10);
		s.add(e1); 
		System.out.println();
		e1 = new Employee(3, "Radha", 70000.0, 20);
		s.add(e1);
		System.out.println();
		e1 = new Employee(2,"Kartik",60000.0,10);
		s.add(e1);
		System.out.println();
		e1 = new Employee(4,"Mita",60000.0,20);
		s.add(e1);
		System.out.println();
		e1 = new Employee(2,"Kartik",60000.0,10);
		s.add(e1);
		System.out.println();
		e1 = new Employee(3, "Radha", 70000.0, 20);
		s.add(e1);
		System.out.println();
		e1 = new Employee(3, "Radha", 70000.0, 20);
		s.add(e1);
		System.out.println();
		//Without overriding anything in Employee class
		//It will call Object.hasCode() ...which generates a unique code for every new object
		//Then will put each entry in different Bucket
		//So each bucket has only one entry so "Object.equals()" will not be called for any "add" operation
		
	//	System.out.println(s + "\n"); //without overriding hashCode() and equals() will also print duplicates
		
		
		//Now after overriding hashCode() and equals()
		//for each add operation it will call hashCode() of employee
		//if two obj have same hashCode then it will compare it with each element in the bucket
		//  using the "equals()" method
		System.out.println(s + "\n");
		
		
		
		if (s.contains(new Employee(4,"Mita",60000.0,20)))
			System.out.println("Mita found ");
		else
			System.out.println("Mita not found");
		
		
		System.out.println();
		
		
		if (s.contains(new Employee(9, "Virat", 70000, 20)))
			System.out.println("Virat Found");
		else
			System.out.println("Virat not found");

	}

}
