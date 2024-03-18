package interfaces;

public interface Bounceable {  
	
	//variables are static + final + public by default
	int baseBounceFactor = 4;
	
	// methods are public + abstract by default
	void bounce();
	void setBounceFactor(int bf);

	default void sayOut()
	{
		System.out.println("I AM A DEFAULT METHOD IN BOUNCEABLE INTERFACE");
	}
	
	
	

}
