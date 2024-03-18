package exceptionhandling;

import java.io.*;
//USING TRY-CATCH TO HANDLE EXCEPTIONS
public class ExceptionEx2 {

	public static void main(String[] args) {
		
		File f = new File("Mohak.java"); //File() constructor doesn't throw any exception even if file is not found
		
//      As these statements might throw exception....we need to handle them using try/catch
//		FileReader fr = new FileReader(f); //FileReader() constructor throws a FileNotFound Exception
//		fr.read();  //read() function throws a IOException
//		fr.close(); //close() throws a IOException
		
		try 
		{
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
		
		System.out.println("Program continues");
		
		
	}

}
