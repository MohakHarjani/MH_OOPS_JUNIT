package equality;

import java.util.ArrayList;
import java.util.Arrays;

import equality.Employee;

public class ObjectEquality {

	public static void main(String[] args) {
		
		Employee[] emps1 = new Employee[] { new Employee(1,"Mohak",50000.0,10), new Employee(2,"KK",60000.0,11)};
		Employee[] emps2 = new Employee[] { new Employee(1,"Mohak",50000.0,10), new Employee(2,"KK",60000.0,11)};
		System.out.println(emps1 == emps2); //false
		System.out.println(emps1.equals(emps2)); //false
		
		System.out.println(Arrays.equals(emps1, emps2)); //true

		int num1 = 5;
		int num2 = 6;
		System.out.println(num1 == num2);  //false
		//Primitives are compared exactly by value (no Wrapper classes, no equals method)
		//direct bit pattern / direct values compared
		
		//=====================================================================================================
		String s1 = "Mohak";
		String s2 = "Mohak";
		System.out.println(s1 == s2); //true
		//Java uses a String Pool
		//For "Strings" with same literals in it...Java makes sure that both point to same location
		//That's why "==" gives tru
		
		
		System.out.println(s1.equals(s2)); //true
		//This gives true because, "String" class has overriden the default "equals" from "Object" class 
		//The overriden "equals" in "String" comapres string char by char
		
		//==========================================================================================================
		//for object types "==" only checks whether both the objects point to the same location (Address)
		
		
		StringBuilder sb1 = new StringBuilder("Mohak");
		StringBuilder sb2 = new StringBuilder("Mohak");
		System.out.println(sb1 == sb2); //false
		// "==" compares whether both objects point to same location
		// but as new objects are created both point to different locations
		
		
		System.out.println(sb1.equals(sb2)); //false
		//StringBuilder "DOES NOT" override the equals method of Object class
		//So the "equals" method of "Object" is called
		// "equals" method of "Object" has the following code inside it
	    //  return (this == obj);
		//So this will again return false, as both object points to diff locations
		
		//=====================================================================================================================
		//for user made classes and it's objects
		//we have to override 
		Employee emp1 = new Employee(1,"Mohak",50000.0,10);
		Employee emp2 = new Employee(1,"Mohak",50000.0,10);
		
		System.out.println(emp1 == emp2);  //false...."==" simply checks for same address
		
		//without overriding the equals method
		System.out.println(emp1.equals(emp2));  //false
		//this calls the equals method of Object
		//and equals method of Object simply checks for same addresses
		
		
		//after overriding the equals method
		System.out.println(emp1.equals(emp2)); //true
		//this will now call the equals method of Employee
		
		System.out.println(emp1.equals(new Object())); //false
		//see the equals method in Employee class
		
		//=============================================================================================================
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1, 2, 3};
		System.out.println(arr1 == arr2); //false
		//Both point to diff locations
		
		System.out.println(arr1.equals(arr2)); //false
		//Arrays class also don't override "equals" method
		//So only address locations are compared
		
		
		System.out.println(Arrays.equals(arr1, arr2)); //true
		//This "equals" method is not the one which is overriden from Object
		//This equals method is a static method in Arrays class
		//equals method is overloaded in Arrays......here int[], int[] one will be called
		//This compares the contents of arrays by 
		//   -> calling "==" on primitives  [here for int it will call ==]
		//   -> calling "equals" on objects
		
		//============================================================================================================
//		
//		Employee[] emps1 = new Employee[] { new Employee(1,"Mohak",50000.0,10), new Employee(2,"KK",60000.0,11)};
//		Employee[] emps2 = new Employee[] { new Employee(1,"Mohak",50000.0,10), new Employee(2,"KK",60000.0,11)};
//		System.out.println(emps1 == emps2); //false
//		System.out.println(emps1.equals(emps2)); //false
//		
//		System.out.println(Arrays.equals(emps1, emps2)); //true
//		//this method compares each index of emps1 and emps2 
//		//by calling equals method on "Objects"
//		//here Object[], Object[] ...equals will be called
		
		//=====================================================================================================================
		
		ArrayList<Integer> list1 = new ArrayList();
		list1.add(1); list1.add(2); list1.add(3);
		
		ArrayList<Integer> list2 = new ArrayList();
		list2.add(1); list2.add(2); list2.add(3);
		
		System.out.println(list1 == list2); //false...Both have diff addresses
		System.out.println(list1.equals(list2)); //true
		//ArrayList has an overriden equals method
		
		//======================================================================================================
		//to simulate the behaviour of "==" we can use hashCode to compare
		//each object has a unique hashcode
		
		int hashCode1 = emp1.hashCode();	
		int hashCode2 = emp2.hashCode();
		System.out.println(hashCode1 == hashCode2); //false
		//both objects are diff and at diff memory locations
		//====================================================================================================
		
		
	


		
		
		
	}

}
