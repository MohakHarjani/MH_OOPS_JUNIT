package methodreference;

import java.util.Arrays;
import java.util.List;

interface MyInterface1{
	int interfaceSquare(int num); //exact same signature as of the instance method of MyClass
	
}
class MyClass1{
	
	int num;
	
	MyClass1(int num)
	{ this.num = num; }
	
	int classSquare(int n)
	{
		return (n * n);
	}
}
public class InstanceMethodRef {
	public static void main(String[] args) {
		
		MyInterface1 mi1 = (int num)->num * num;
		MyClass1 obj = new MyClass1(5);
		MyInterface1 mi2 = obj :: classSquare;
		
		System.out.println(mi1.interfaceSquare(89));
		System.out.println(mi1.interfaceSquare(89));
		
		
		List<Integer>nums = Arrays.asList(1, 3, 5, 6, 7);
		nums.forEach((Integer num)->System.out.println(num));
		System.out.println();
		
		nums.forEach(System.out :: println);

	}

}
