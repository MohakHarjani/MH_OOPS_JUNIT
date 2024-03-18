package interfaces;

public class UseInterface {

	public static void main(String[] args) {
		
		Ball b = new Ball("Cosco");
		Tyre t = new Tyre("MRF");
		getDetails(b);
		getDetails(t);
		
		Bounceable ob = new Ball("Season");
		getDetails(ob);
		ob = new Tyre("CEAT");
		getDetails(ob);
		
		
		
		ob.sayOut();
//		ob.rollSpeed();  //we cannot call static methods of interfaces by object
		Rollable.rollSpeed(); //we can only call by Interface 
	}
	static void getDetails(Bounceable obj)
	{
		System.out.println(obj);
		obj.bounce();
		obj.setBounceFactor(400);
		obj.bounce();
		
		System.out.println();
	}

}
