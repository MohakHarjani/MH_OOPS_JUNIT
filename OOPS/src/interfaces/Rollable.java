package interfaces;

public interface Rollable {  //NEWER JAVA VERSION INTERFACE (abstract + default + static methods all allowed)
	void roll();
	
	default void sayOut()
	{
		System.out.println("I AM A DEFAULT METHOD IN ROLLABLE INTERFACE");
	}
	static void rollSpeed()
	{
		System.out.println("I AM A STATIC METHOD IN ROLLABLE INTERFACE");
	}

}
