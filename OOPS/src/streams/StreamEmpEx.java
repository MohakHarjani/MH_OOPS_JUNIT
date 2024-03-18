package streams;
import java.util.*;
import java.util.stream.*;

public class StreamEmpEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//forEach, map, collect, count, filter, reduce, distinct, sorted, findFirst, findAny

		List<Employee> employees = new ArrayList();
		
		employees.add(new Employee(2,"Kartik",20000.0,20));
		employees.add(new Employee(2,"Kartik",20000.0,20));
		employees.add(new Employee(3,"Kshitij",75000.0,30));
		employees.add(new Employee(4,"Virat",80000.0,20));
		employees.add(new Employee(1,"Mohak",38000.0,10));
		employees.add(new Employee(1,"Mohak",38000.0,10));
		employees.add(new Employee(8,"Rohit",34000.0,10));
		
		//=========================================================================
		
		employees.stream().forEach((Employee emp)->System.out.println(emp));
		System.out.println();
		
		//============================================================================
		
		//map returns a stream of string...map can return any Type of objects
		employees.stream().map((Employee emp)-> "Mr. " + emp.getEmpName())
		                  .forEach((String empName)->System.out.print(empName + ",  "));
		System.out.println("\n");
		
		//==================================================================================
		
		//collectors
		List<Employee>empList = employees.stream().filter((Employee emp)->emp.getEmpSal() > 37000)
		                                          .collect(Collectors.toList());
		System.out.println(empList);
		
		Set<Employee>empSet = employees.stream().filter((Employee emp)->emp.getEmpSal() > 37000)
                                                 .collect(Collectors.toSet());
		System.out.println(empSet + "\n");
		
		//=======================================================================================
		
		//get names of employees having salary > 370000 in a Set
		
		Set<String>empNames = employees.stream().filter((Employee emp)->emp.getEmpSal() > 37000)
		                  .map((Employee emp)->emp.getEmpName())
		                  .collect(Collectors.toSet());
		
		System.out.println(empNames + "\n");
		
		//============================================================================================
		
		//get list of distinct employees names of dept = 10
		//distinct here uses hashCode() and equals() of Employee 
		List<String>deptEmployees = employees.stream().distinct()
							                  .filter((Employee emp)->emp.getDeptNo() == 10)
							                  .map((Employee emp)->emp.getEmpName())
							                  .collect(Collectors.toList());
		System.out.println(deptEmployees + "\n");
		
		//===============================================================================================
		
		//uses compareTo method of Employee class
		List<String>sortedEmployees = employees.stream().sorted()
				                                        .map((Employee emp)->emp.getEmpName())
				                                        .collect(Collectors.toList());
		System.out.println(sortedEmployees);
		
		//=================================================================================================
		
		//gets the first employee's name whose deptNo = 10
		//filter returns stream of employees
		//map return stream of employee names (String)
		//findFirst returns an optional
		Optional<String>op = employees.stream().filter((Employee emp)->emp.getDeptNo() == 10)
				                        .map((Employee emp)->emp.getEmpName())
				                        .findFirst();  
		if (op.isPresent())
			System.out.println("First Dept-10 employee  = " + op.get());
		else
			System.out.println("No employee in Dept-10");
		
		
		//filter return empty Stream....map returns empty Stream...findFirst returns Optional will null...
		//orElse returns the passed string
		String firstEmp = employees.stream().filter((Employee emp)->emp.getDeptNo() == 90)
									        .map((Employee emp)->emp.getEmpName())
									        .findFirst()
									        .orElse("No employee in Dept-10");
		System.out.println("First Dept-10 employee  = " + firstEmp);
		
		//===================================================================================================
		
		double totalSal = employees.stream().map((Employee emp)->emp.getEmpSal())
				                           .reduce(0.0, (Double acc, Double sal)-> (acc + sal));
		
		System.out.println("Total salary amount = " + totalSal);
		
		//========================================================================================
	}

}
