package accesscontrol.pack1;


public class Employee {
	public int empId;
	public String empName;
	
	private double empSal;
	
    int deptNo;
	
	protected int marks;
	//========================================================================
	public Employee()
	{
		System.out.println("No paramter constructor called");
	}
	public Employee(int empId, String empName, double empSal, int deptNo) {
		System.out.println("In the employee constructor ");
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.deptNo = deptNo;
	}
	//===============================================================================
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	//===================================================================================


}