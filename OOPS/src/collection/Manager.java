package collection;

public class Manager extends Employee{
	private int teamSize;
	private double pettyCash;
	private double varPay;
	//================================================================================================
	public Manager(int empId, String empName, double empSal, int deptNo, int teamSize, double pettyCash,
			double varPay) {
		super(empId, empName, empSal, deptNo);
		
//		System.out.println("In the Manager Constructor");
		this.teamSize = teamSize;
		this.pettyCash = pettyCash;
		this.varPay = varPay;
	}
	//=====================================================================================================
	@Override
	double getAnnualSal()
	{
		double x =  this.getEmpSal()  * 12 + this.pettyCash + this.varPay;
		double y = super.getAnnualSal() + this.pettyCash + this.varPay;
		System.out.println("x =>" + x +",   y => " + y);
		
		return x;
		
	}
	//====================================================================================================
	@Override
	public String toString()
	{
		return super.toString() + ", teamSize : " + this.teamSize + 
				", pettyCash : " + this.pettyCash +
				", varPay : " + this.varPay;
		
	}
	//=====================================================================================================
	void managerSpecific() 
	{
		System.out.println("This is an manager specific function ");
	}
	//=======================================================================================================
}
