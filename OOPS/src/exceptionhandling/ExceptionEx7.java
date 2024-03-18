package exceptionhandling;

import java.io.*;

//USING FINALLY
public class ExceptionEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("Mohak.java");
		
		try {
		   fun(f);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		

	}
	static void fun(File f) throws IOException
	{
		FileReader fr = null;
		try
		{
			fr = new FileReader(f);
			fr.read();  //if error occurs here.....the "fr" will remain unclosed
		}
		finally 
		{
			System.out.println("In finally");
			//cleanup tasks......
			if (fr != null)
				fr.close();
		}
		System.out.println("Remaining fun...");
	}

}
