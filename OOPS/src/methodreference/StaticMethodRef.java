package methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

interface MyConvert{
	int convert(String s);  //exact same signature as parseInt from Integer class
}
public class StaticMethodRef {
	public static void main(String[] args)
	{
		List<Integer>nums = Arrays.asList(12, 13, 78, 56, 45);
		
		int sum = nums.stream().reduce(0, (a, b)->a + b);
		System.out.println(sum);
		sum = nums.stream().reduce(0, Math::addExact);
		System.out.println(sum + "\n");
		
		
		
		int mxNum = nums.stream().reduce(0, (a, b)->Math.max(a, b));
		System.out.println(mxNum);
		mxNum = nums.stream().reduce(0, Math::max);
		System.out.println(mxNum + "\n");
		
		
		String str = "98";
		MyConvert c1 = (String s)->Integer.parseInt(s);
		MyConvert c2 = Integer::parseInt;
		int num = c1.convert(str);
		System.out.println(num);
		num = c2.convert(str);
		System.out.println(num + "\n");
		
		//a better way to do above is to make a function
		System.out.println( fun((String s)->Integer.parseInt(s)) );
		System.out.println( fun(Integer :: parseInt) );
		
		
		
	}
	static int fun(MyConvert c)
	{
		return c.convert("98");
	}

}
