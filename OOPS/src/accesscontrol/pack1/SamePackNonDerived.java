package accesscontrol.pack1;

public class SamePackNonDerived {

	public static void main(String[] args)
	{
		Employee emp = new Employee(104216, "Mohak Harjani", 35000.00, 4);
		
		int myId = emp.empId; //public members can be accessed here
//		double mySal = emp.empSal;  //private members cannot be accessed here
		int myDept = emp.deptNo; //default can be accessed
		int myMarks = emp.marks; //protected can be accessed here
		
		
		
		
	}

}
