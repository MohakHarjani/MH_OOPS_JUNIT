package overriding;

public class Employee {
	private int empId;
	private String empName;
	private double empSal;
	private int deptNo;
	//========================================================================
	public Employee()
	{
		System.out.println("No paramter constructor called");
	}
	public Employee(int empId, String empName, double empSal, int deptNo) {
//		System.out.println("In the employee constructor ");
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
	double getAnnualSal ()
	{
		return this.getEmpSal() * 12;
	}
	
	@Override
	public String toString()
	{
		return "empId : " + this.empId + 
				", empName : " + this.empName + 
				", empSal : " + this.empSal + 
				", deptNo : "  + this.deptNo;
	}
	@Override
	public boolean equals(Object emp)
	{
		System.out.println("Equals method called on = " + ((Employee)emp).empName);
		return this.empId == ((Employee)emp).empId;
	}
	@Override
	public int hashCode()
	{
		System.out.println("Employee hashCode method called");
		return this.deptNo;
	}
	//====================================================================================
	void empSpecific() 
	{
		System.out.println("This is an employee specific function ");
	}
	


}
