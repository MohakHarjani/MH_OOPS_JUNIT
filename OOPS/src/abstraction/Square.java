package abstraction;

public class Square extends Shape{
	public Square(int side)
	{
		super(side);
	}
	
	@Override
	public String toString()
	{
		return "This is a Square...." + "Side = " + this.getSide1();
	}
	
	@Override
	int getArea()
	{
		int side = this.getSide1();
		return (side * side);
	}
	
	@Override
	int getPerimeter()
	{
		int side = this.getSide1();
		return (3 * side);
	}
}
