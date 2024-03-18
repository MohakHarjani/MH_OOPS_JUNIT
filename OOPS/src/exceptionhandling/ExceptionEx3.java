package exceptionhandling;

import java.io.*;
//HANDLING EXCEPTIONS INSIDE A FUNCTION
public class ExceptionEx3 {
	public static void main(String[] args)
	{
		
		File f = new File("Mohak.java");
		
		//===========================================================
		//METHOD-1
		fun1(f);
		
		//===========================================================
		//METHOD-2
		try
		{
		   fun2(f);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		//===============================================================
	}
	//============================================================================================================
	//METHOD-1....Handle the Exception inside the function only
	static void fun1(File f)
	{
		try {
		FileReader fr = new FileReader(f); //FileReader() constructor throws a FileNotFound Exception
		fr.read();  //read() function throws a IOException
		fr.close(); //close() throws a IOException
		}
		catch(FileNotFoundException e) //once the matching catch is found, no other catch block is checked
		{
			System.out.println("Problem in finding the file....");
			System.out.println(e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("Problem in IO in file....");
			System.out.println(e.getMessage());
		}
		System.out.println("Remaining in fun1"); //THIS IS EXECUTED
		
	}
	
	//========================================================================================================
	//METHOD-2....Use "throws" and propagate exception to the caller
	//Now this function tells the compiler that the code inside this function might raise an Exception
	//Now it becomes the duty of "caller" to aprropriately handle the exception
	//This is like "PROPAGATING" the Exception to the caller of function
	//FileNotFound Exception extends IOException
	static void fun2(File f) throws IOException
	{
		FileReader fr = new FileReader(f); //FileReader() constructor throws a FileNotFound Exception
		fr.read();  //read() function throws a IOException
		fr.close(); //close() throws a IOException
		
		//If exception occurs in function....
		//The lines following it will not be executed
		//and control will get back to caller along with "Throwing" an exception
		System.out.println("Remaining in fun2");  //THIS NEVER RUNS
		
		
	}
	//===================================================================================================
}
