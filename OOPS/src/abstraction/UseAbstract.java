package abstraction;

public class UseAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printDetails(new Square(5));
		printDetails(new Rectangle(2, 4));
		printDetails(new Triangle(2, 9.0));
		
		Shape s = new Square(11);
		printDetails(s);
		
	}
	static void printDetails(Shape obj)
	{
		System.out.println(obj);
		System.out.println("Area = " + obj.getArea());
		System.out.println("Perimeter = " + obj.getPerimeter());
		System.out.println();
	}

}
