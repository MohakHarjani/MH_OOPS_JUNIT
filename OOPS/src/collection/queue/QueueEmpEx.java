package collection.queue;
import java.util.*;

import collection.Employee;

public class QueueEmpEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Employee>q  = new LinkedList();
		
		Employee e1 = new Employee(1,"Mohak",50000.0,10);
		Employee e2 = new Employee(3, "Radha", 70000.0, 20);
		Employee e3 = new Employee(2,"Kartik",60000.0,10);
		Employee e4 = new Employee(4,"Mita",60000.0,20);
		Employee e5 = new Employee(9,"Geeta",70000.0,20);
		Employee e6 = new Employee(11,"Seeta",80000.0,30);
		
		q.add(e1);
		q.add(e2);
		q.add(e3);
		q.add(e4);
		q.add(e5);
		q.add(e6);
		
		ArrayList<Integer> list = new ArrayList();

		
		while(!q.isEmpty())
			System.out.print(q.poll());
		
		
		
	}

}
