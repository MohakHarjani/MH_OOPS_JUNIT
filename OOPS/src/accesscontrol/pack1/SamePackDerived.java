package accesscontrol.pack1;

public class SamePackDerived extends Employee{
	public static void main(String[] args)
	{
		Employee emp = new Employee(104216, "Mohak Harjani", 35000.00, 4);
		
		int myId = emp.empId; //public members can be accessed here
//		double mySal = emp.empSal;  //private members cannot be accessed here
		int myDept = emp.deptNo; //default can be accessed
		int myMarks = emp.marks; //protected can be accessed here
		
		
		SamePackDerived obj = new SamePackDerived();
		obj.empId = 5;  //public can be accessed
//		obj.mySal = 9000.00;  //private cannot be accesses
		obj.deptNo = 5; //default can be accessed
		obj.marks = 50;  //protected can be accessed
		
		
	}

}
