package accesscontrol.pack2;
import accesscontrol.pack1.Employee;

public class DiffPackDerived extends Employee{
	public static void main(String[] args)
	{
		Employee emp = new Employee(104216, "Mohak Harjani", 35000.00, 4);
		int myId = emp.empId; //public members can be accessed here
//		double mySal = emp.empSal; //private members cannot be accessed
//		int myDept = emp.deptNo; //default members cannot be accessed
//		int marks = emp.marks; // ???????? DOUBT :(
		
		
		DiffPackDerived obj = new DiffPackDerived();
		obj.empId = 104216; //public members can be accessed
//		obj.empSal = 35000; //private members cannot be accessed
//		obj.deptNo = 4; //default members cannot be accessed
		obj.marks = 7; //protected members can be accessed here :)
		
		
	}

}
