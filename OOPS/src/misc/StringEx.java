package misc;

import java.util.List;
import java.util.stream.Collectors;

public class StringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "MOhHAK";
		s= s.toLowerCase(); //a new String object is created
		System.out.println(s);
		
		//each time a new String obj is created
		s = s.concat("Harjani").toLowerCase().substring(2);
		System.out.println(s);
		
		StringBuilder sb = new StringBuilder(s);
		s= sb.append("Harjani").append(234).substring(1);  
		//only for substring() new String will be created
		
		
		//StringBUilder to String
		s = sb.toString(); //a new string will be created
		s = sb.substring(0);
		
		
		//multi-line strings
		//s.lines() gives a stream of lines [\n as a delimiter for line break]
		s = "Mohak harjani is good \n He knows Java";
		List<String>sLines = s.lines().collect(Collectors.toList());
		System.out.println(sLines);
		
		//chars gives intStream of chars (ascii)
		s = "Mohak";
		s.chars().forEach((int ascii)->System.out.println((char)ascii));
		
		//collect characters in a list
		List<Character>lst = s.chars().mapToObj((int ch)->(char)ch)
				                      .collect(Collectors.toList());
		System.out.println(lst);
		
		//characters to char array
		char[] chars = s.toCharArray();
		//characters to byte array
		byte[] byarr = s.getBytes();

		for (int i = 0; i < s.length(); i++)
			System.out.print(s.charAt(i));

		
		s = "Mohak";
		System.out.println(s.repeat(5));
		//===================================================================================================
		
		//strip considers even the unicode value
		//trim doesn't
		//strip is unicode aware....
		//but trim will not
		s = "Virat \u2005";  
		System.out.println(s.trim().equals(s.strip())); //false
		System.out.println(s.trim());
		System.out.println(s.strip());

		s = "\t    Kohli    \u2005";
		System.out.println(s.trim());
		System.out.println(s.strip());

		s = "\t   Rohit    \u2005";
		System.out.println(s.stripLeading());

		s = "\t    Sharma    \u2005";
		System.out.println(s.stripTrailing());




		

	}

}
