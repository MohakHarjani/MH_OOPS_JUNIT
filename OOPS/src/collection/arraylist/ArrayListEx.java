package collection.arraylist;
import java.util.*;
import java.util.function.Consumer;
public class ArrayListEx {

	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1); nums.add(3); nums.add(5); nums.add(9); nums.add(11); nums.add(13);
		System.out.println(nums);
		//=============================================================================
		int numAtIdx2 = nums.get(2);
		int numAtIdx3 = nums.get(3);
		System.out.println(numAtIdx2 + ", " + numAtIdx3);
		//================================================================================
		nums.set(2, 2);
		nums.set(3,  4);
		System.out.println(nums);
		//===============================================================================
		nums.remove(1);
		nums.remove(Integer.valueOf(11));
		System.out.println(nums);
		//================================================================================
		Iterator<Integer>it = nums.iterator();
		while(it.hasNext())
		{
			int num = it.next();
			System.out.print(num + "  ");
		}
		System.out.println();
		//==================================================================================
		Consumer<Integer>c = (Integer num)->{ System.out.print(num + " "); };
		nums.forEach(c);
		System.out.println();
		
		nums.forEach((Integer num)->{
			System.out.print(num + " ");
		});

	}

}
