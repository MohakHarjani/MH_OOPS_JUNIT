package exceptionhandling;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//A FUNCTION THROWING TWO EXCEPTIONS, PROPAGATING BOTH EXCEPTIONS BACK
public class ExceptionEx5 {
	public static void main(String[] args)  
	{
		File f = new File("Mohak.java");
		try {
		   fun1(f);
		}
		catch(IOException | SQLException e) //will catch both IO and SQL Exception
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Main program continues....");
	}
	//==========================================================================================
	static void fun1(File f) throws IOException, SQLException  //two non-related exceptions
	{
		fun2(f);
		fun3();
		
		System.out.println("Remaining in fun2");
		
	}
	static void fun2(File f) throws IOException
	{
		FileReader fr = new FileReader(f); //FileReader() constructor throws a FileNotFound Exception
		fr.read();  //read() function throws a IOException
		fr.close(); //close() throws a IOException
		
		System.out.println("Remaining in fun2");
	}
	static void fun3() throws SQLException 
	{
		Connection con = DriverManager.getConnection("");	
		System.out.println("Remaining in fun3");
		
	}
	//==================================================================================================
}
