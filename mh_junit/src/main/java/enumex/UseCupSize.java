package enumex;

import java.util.EnumSet;

public class UseCupSize {

	public static void main(String[] args) {
		
		CupSize small = CupSize.SMALL;
		String smallName = small.name();
		int smallIndex = small.ordinal();
		int smallPrice = small.getPrice();
		
		System.out.print(smallName + ", " + smallIndex + ", " + smallPrice + "\n");
		System.out.println(small);  //small.toString() returns the name of enum ref
		
		
		//.values() returns an array of all values 
		//in the order they are declared inside the enum
		CupSize[] cupValues = CupSize.values(); 
		for (CupSize cz : cupValues)
		{
			System.out.println(cz.name() + ", " + cz.ordinal() + ", " + cz.getPrice() + "\n");
		}
		
		
		//if we want values as a set instead of an array
		//enum's cannot even contain duplicate values
		//we use EnumSet to reduce time complexity of checking 
		// whether a value  is present in set or nor (using contains)
		EnumSet<CupSize> cupSet = EnumSet.allOf(CupSize.class);
		cupSet.stream()
		.forEach((cz)->System.out.println(cz.name() + ", " + cz.ordinal() + ", " + cz.getPrice() ));
		
		
		boolean present = cupSet.contains(CupSize.SMALL);
		System.out.println(present);
	

	}

}
