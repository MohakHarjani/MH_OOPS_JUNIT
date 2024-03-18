package abstraction;

abstract public class Shape {
	private int side1, side2;
	private double height;
	//===============================================================================
	//CONSTRUCTORS
	//SIDE
	//public Shape() { }
	public Shape(int side1) {
		this.side1 = side1;
	}
	
	//LENGTH, BREADTH
	public Shape(int side1, int side2) {
		super();
		this.side1 = side1;
		this.side2 = side2;
	}
	
	//BASE, HEIGHT
	public Shape(int side1, double height) {
		super();
		this.side1 = side1;
		this.height = height;
	}
	//================================================================================
	//GETTERS 
	public int getSide1() {
		return side1;
	}

	public int getSide2() {
		return side2;
	}

	public double getHeight() {
		return height;
	}
	//=================================================================================
	//ABSTRACT METHODS
	abstract int getArea();
	abstract int getPerimeter();

}
