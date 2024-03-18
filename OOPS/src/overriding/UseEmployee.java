package overriding;

public class UseEmployee {
	
	static void fun(Employee emp)
	{
		//IMPORTANT
		if (emp instanceof Manager) //instanceof checks the run-time type of object
		{
		   ((Manager)emp).managerSpecific(); //this casting is required for compile time
		}
		System.out.println(emp);
		System.out.println(emp.getAnnualSal());
	}

	public static void main(String[] args) {
		
    	Employee e = new Employee(104216, "Mohak Harjani", 35000, 4);
		
		Manager m = new Manager(104216, "Mohak Harjani", 35000, 4, 9, 5000, 8000);
//		System.out.println(m.getAnnualSal());
		
		Employee m2 = new Manager(104215, "Kartik Tomar", 36000, 6, 10, 7000, 9000);
//		System.out.println(m2.getAnnualSal());
		
		fun(m);
	}
	

}
