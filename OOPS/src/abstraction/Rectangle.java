package abstraction;

public class Rectangle extends Shape{
	
	public Rectangle(int length, int breadth)
	{
		super(length, breadth);
	}
	
	@Override
	public String toString()
	{
		return "This is a Rectangle...." + "Length = " + this.getSide1() + ", Breadth = " + this.getSide2();
	}
	
	@Override
	int getArea()
	{
		int length = this.getSide1();
		int breadth = this.getSide2();
		return (length * breadth);
	}
	
	@Override
	int getPerimeter()
	{
		int length = this.getSide1();
		int breadth = this.getSide2();
		return 2 * (length + breadth);
	}


}
