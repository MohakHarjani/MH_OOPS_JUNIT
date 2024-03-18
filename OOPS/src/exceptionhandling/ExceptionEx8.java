package exceptionhandling;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//USING TRY-WITH-RESOURCES ...... NO NEED OF FINALLY
public class ExceptionEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("Mohak.java");
		
		try {
		   fun(f);
		}
		catch(IOException | SQLException e)
		{
			System.out.println(e.getMessage());
		}
		

	}
	static void fun(File f) throws IOException, SQLException
	{
		//the resources inside this round bracket of try will be automatically closed
		//the resources will only be automatically closed when these classes
		//implement "Autoclosable" interface
		try (
				FileReader fr = new FileReader(f);
				Connection con = DriverManager.getConnection("");	
			)
		{
						fr.read();  //if error occurs here.....the "fr" will remain unclosed
		}

		//No need of finally now
		System.out.println("Remaining fun...");
	}

}
