package collection;

public class Employee implements Comparable<Employee>{
	private int empId;
	private String empName;
	private double empSal;
	private int deptNo;
	//========================================================================
	public Employee()
	{
//		System.out.println("No paramter constructor called");
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
	//====================================================================================================
	@Override
	public String toString()
	{
		return "empName : " + this.empId + 
				", empName : " + this.empName + 
				", deptNo : "  + this.deptNo  + "\n";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		System.out.println("Employee equals called on => " +this.empName + ", " + ((Employee)obj).empName );

		if (obj instanceof Employee)
		{
			return ((Employee)obj).empId == this.empId;
		}
		
		//if obj is not an instance of Employee, ClassCase exp will occur
		//so return false
		return false; 
		
	}
	@Override
	public int hashCode()
	{
		System.out.println("Employee hashCode method called on " + this.empName);
		return this.getDeptNo();  //make buckets based on deptNo
	}
	@Override
	public int compareTo(Employee newObj) {  //I want to sort in ASCENDING order of empId
		//this -> refers to existing Obj
//		if (this.empId < newObj.empId)
//			return -1;
//		else if (this.empId > newObj.empId)
//			return +1;
//		else return 0;
//		
		System.out.println("CompareTo method called on " + this.empName + ", " + ((Employee)newObj).empName);
		return this.empId - newObj.empId;
	}

	
	//====================================================================================================

	double getAnnualSal ()
	{
		return this.getEmpSal() * 12;
	}
	void empSpecific() 
	{
		System.out.println("This is an employee specific function ");
	}
	//=====================================================================================================

	


}
