package collection.priorityqueue;

import java.util.*;
import collection.Employee;


public class PriorityQueueEmpEx {
	static void fun(Comparator<Employee> cc)
	{
		Queue<Employee>pq = new PriorityQueue<Employee>(cc);
		
		Employee e1 = new Employee(1,"Mohak",50000.0,10);
		Employee e2 = new Employee(3, "Radha", 70000.0, 20);
		Employee e3 = new Employee(2,"Kartik",60000.0,10);
		Employee e4 = new Employee(4,"Mita",60000.0,20);
		Employee e5 = new Employee(9,"Geeta",70000.0,20);
		Employee e6 = new Employee(11,"Seeta",80000.0,30);
		
		pq.add(e1);
		pq.add(e2);
		pq.add(e3);
		pq.add(e4);
		pq.add(e5);
		pq.add(e6);
		
		while(!pq.isEmpty())
		{
			System.out.print(pq.poll());
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Order by = empId (using Comparable) (ascending)");
		fun(null); //by default will use Comparable's compareTo
		
		System.out.println("Order by = empSal (descending)");
		fun((Employee a, Employee b)->{
			return (int)(a.getEmpSal() - b.getEmpSal());
		});
		
		System.out.println("Order by =  empName (lexicographic)");
		fun((Employee a, Employee b)->{
			return ( a.getEmpName().compareTo(b.getEmpName()) );
		});
		
		System.out.println("Order by =  empName (character count)");
		fun((Employee a, Employee b)->{
			return ( a.getEmpName().length() - b.getEmpName().length() );
		});
		
	}
	


}


