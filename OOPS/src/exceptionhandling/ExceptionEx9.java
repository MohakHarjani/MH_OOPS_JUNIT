package exceptionhandling;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//RETHROWING THE EXCEPTION AFTER PARTIAL HANDLING
//Sometimes the function only wants to handle some subpart of exception
//and want to pass the exception info again to the caller
//we can re-throw the exception
public class ExceptionEx9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("Mohak.java");
		
		try {
		   fun(f);
		}
		catch(IOException e)
		{
			System.out.println("Inside Main = " + e.getMessage());
		}
		

	}
	static void fun(File f) throws IOException
	{
		//the resources inside this round bracket of try will be automatically closed
		//the resources will only be automatically closed when these classes
		//implement "Autoclosable" interface
		try (FileReader fr = new FileReader(f))
		{
			fr.read();  //if error occurs here.....the "fr" will remain unclosed
		}
		catch(IOException e)
		{
			System.out.println("Inside fun = " + e.getMessage());
			throw e; //again throwing the same exception
		}
		System.out.println("Remaining fun...");
	}

}
