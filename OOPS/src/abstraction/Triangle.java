package abstraction;

public class Triangle extends Shape{
	public Triangle(int base, double height)
	{
		super(base, height);
	}
	@Override
	public String toString()
	{
		return "This is a Traiangle...." + "Base = " + this.getSide1() + ", Height = " + this.getHeight();
	}
	
	@Override
	int getArea()
	{
		int base = this.getSide1();
		double height = this.getHeight();
		return (int)(0.5 * base * height);
	}
	@Override
	int getPerimeter()
	{
		return (this.getSide1() * 3);
	}
}
