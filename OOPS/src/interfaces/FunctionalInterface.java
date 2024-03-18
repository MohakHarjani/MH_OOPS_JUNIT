package interfaces;

interface Printable{
	void print(String s);  //exactly one abstract method
	
	static void staticFun() { } //but can have static or default methods
	default void defaultFun() { }
}
class Document implements Printable {

	@Override
	public void print(String s) {
		System.out.println("I am printing " + s);
		
	}
}

public class FunctionalInterface {
	public static void main(String[] args)
	{
		Printable d1 = new Document();
		d1.print("PDF");
		
		//lambda function will create a class implementing Printable
		//will override the abstract function
		//then finally return an instance of the created class
		Printable d2 = (String s)->{
			System.out.println("LAMBDA : I am printing  " + s);
		};
		d2.print("DOCX");
	}
	

}
