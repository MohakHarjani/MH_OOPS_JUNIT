package accesscontrol.pack2;
import accesscontrol.pack1.Employee; 
//start importing from the top level package...it will start finding in the "src" folder

public class DiffPackNonDerived {
	public static void main(String[] args)
	{
		accesscontrol.pack1.Employee e = new accesscontrol.pack1.Employee(104216, "Mohak Harjani", 35000.00, 4);
		
		Employee emp = new Employee(104216, "Mohak Harjani", 35000.00, 4);
		
		int myId = emp.empId; //public members can be accessed here
//		double mySal = emp.empSal; //private members cannot be accessed here
//		int myDept = emp.deptNo; //default members cannot be accessed here
//		int marks = emp.marks; //protected members cannot be accessed here
	}

}
