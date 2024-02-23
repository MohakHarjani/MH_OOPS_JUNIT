package calculator;

public class Calculator {
	
	double op1, op2;

	public Calculator(double op1, double op2) {
		super();
		this.op1 = op1;
		this.op2 = op2;
	}
	//==========================================================
	public double getOp1() {
		return op1;
	}

	public void setOp1(double op1) {
		this.op1 = op1;
	}

	public double getOp2() {
		return op2;
	}

	public void setOp2(double op2) {
		this.op2 = op2;
	}
	//===============================================================================
	public double add()
	{
		return this.op1 + this.op2;
	}
	public double sub()
	{
		return this.op1 - this.op2;
	}
	public double mul()
	{
		return this.op1 * this.op2;
	}
	public double doubleDiv()
	{
		return this.op1 / this.op2;
	}
	public int intDiv()
	{
		int x = (int)this.op1;
		int y = (int)this.op2;
		return x / y;
	}
	//=======================================================================================

}
