package exceptionhandling;

import java.io.*;

//EXCEPTION PROPAGATION CHAINING
public class ExceptionEx4 {
	//we can also add throws "IOException" in main...but then JVM has to handle exception..No use :(
	public static void main(String[] args)  
	{
		File f = new File("Mohak.java");
		try {
		   fun1(f);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Main program continues....");
	}
	static void fun1(File f) throws IOException
	{
		fun2(f);
		System.out.println("Remaining in fun2");
		
	}
	static void fun2(File f) throws IOException
	{
		FileReader fr = new FileReader(f); //FileReader() constructor throws a FileNotFound Exception
		fr.read();  //read() function throws a IOException
		fr.close(); //close() throws a IOException
		
		System.out.println("Remaining in fun2");
	}
}
