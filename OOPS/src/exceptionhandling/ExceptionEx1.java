package exceptionhandling;

//HOW THE EXCEPTION OCCURS..RUNTIME EXCEPTION
public class ExceptionEx1 {
	
	public static void main(String[] args)
	{
		//Runtime Exceptions
		//Compiler won't complain...but might give you warning
		String s = "Mohak";
		System.out.println("before");
		s = null;
		s.concat("Harjani");
		
		//   [This will cause "NullPointerException"..This will be handled by default JVM handler]
		//  compiler will stop the execution here only, and won't run the following lines
		System.out.println("after");
		
		
		//===================================================================================
		
		
		int x = Integer.parseInt("    10   ");  //NumberFormatException....String has spaces
		System.out.println(x);
		//These runtime exception need to be "REMOVED" and not "HANDLED" ideally
		//but still we can use try/catch with the runtime exceptions
	}

}
