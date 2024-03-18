package misc;

public class WrapperEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 3;
		//primitive to object
		Integer numOb1 = num1;
		Integer numOb2 = Integer.valueOf(3);
		Integer numOb3 = 3;
		
		
		//object to other numeric primitives
		int num2 = numOb1.intValue();
		byte num3 = numOb1.byteValue();
		double num4 = numOb1.doubleValue();
		long num5 = numOb1.longValue();
		short num6 = numOb1.shortValue();
		System.out.println(num2 + ", " + num3 + ", " + num4 + ", " + num5 + ", " + num6);
		 
		//for primitives to other numeric primitives
		// curr primitive -> Object -> other primitive
		Integer numOb4 = 4;
		//restSame
		
		
		//String to int
		String s1 = " 10 ";
		int num7 = Integer.parseInt(s1.trim()); //old versions
		int num8 = Integer.parseInt(s1.strip());  //unicode aware ..new versions ...
		System.out.println(++num7 + ", " + ++num8);
		
		
		s1 = "26"; // ((8^1 * 2) + (8^0 * 6)) = 22
		int num9 = Integer.parseInt(s1, 8);   //8 defines the base (octal)
		System.out.println(num9);
		
		
		//int to String
		num9 = 12;
		s1  = Integer.toString(num9);
		System.out.println(s1);
		
		s1 = Integer.toBinaryString(num9);
		System.out.println(s1);
		
		s1 = Integer.toHexString(num9);
		System.out.println(s1);
		
		s1 = Integer.toOctalString(num9);
		System.out.println(s1);

		//(3^2 * 1) + (3^1  * 1) + (3^0 * 0);
		s1 = Integer.toString(num9, 3); //3 is radix
		System.out.println(s1);

	}

}
