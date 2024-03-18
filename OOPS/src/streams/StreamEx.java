package streams;
import java.util.*;
import java.util.stream.*;
public class StreamEx {

	public static void main(String[] args) {
	
		List<Integer>nums = new ArrayList();
		
		nums.add(1);  nums.add(78);
		nums.add(34); nums.add(99);
		nums.add(34); nums.add(6);
		nums.add(34); nums.add(99);
		
		//=====================================================================================================
		//Simple Printing the list [forEach]...forEach has a Consumer interface as a param
		Iterator<Integer>it = nums.iterator();
		while(it.hasNext())
		{
			int num = it.next();
			System.out.print(num + ", ");
		}
		System.out.println();
		
		
		Stream<Integer>numsStream = nums.stream();
		numsStream.forEach((Integer num)->{    //for each is a termination function
			System.out.print(num + ", ");
		});
		System.out.println("\n");
		
		//connection is closed after forEach
		//after a stream is terminated we cannot use it
		//So following line won't work
		//numsStream.forEach((Integer num)->System.out.print(num + ", "));
		//=================================================================================================
		
		//Altering values then printing  [map + forEach].....map uses Function interface as a param
		it = nums.iterator();
		while(it.hasNext())
		{
			int num = it.next();
			System.out.print(num * 2 + ", ");
		}
		System.out.println();
		
		
		//map returns a Stream
		//so we can chain a forEach method on ".map"
		numsStream = nums.stream(); //opening a new connection
		numsStream.map((Integer num)->num * 2)
		          .forEach((Integer num)->System.out.print(num + ", "));
		System.out.println("\n");
		
		//=====================================================================================================
		
		//Alter values + collect the results in a Set [map + collect]
		//collect is a termination method
		Set<Integer>st = new HashSet();
		it = nums.iterator();
		while(it.hasNext())
		{
			int num = it.next();
			st.add(num * 2);
		}
		System.out.println(st);
		
		numsStream = nums.stream();
		st = numsStream.map((Integer num)->num * 2)
		               .collect(Collectors.toSet());  //Collectors.toSet() returns a Collector
		System.out.println(st + "\n");
		
		//==========================================================================================
		
		//Counting the numbers of elements
		long count = 0;
		it = nums.iterator();
		while(it.hasNext())
		{
			int num = it.next();
			count++;
		}
		System.out.println(count);
		

		numsStream = nums.stream(); //re-opening the stream
		count = numsStream.count();
		System.out.println(count);
		System.out.println("\n");
		
		//==========================================================================================
		
		//Filtering the elements based on some condition
		//use filter + collect (to store)
		List<Integer>ans = new ArrayList();
		it = nums.iterator();
		while(it.hasNext())
		{
			int num = it.next();
			if (num % 2 == 0)
				ans.add(num);
		}
		System.out.println(ans);
		
		
		numsStream = nums.stream();
		ans = numsStream.filter((Integer num)->(num % 2 == 0))
				        .collect(Collectors.toList());
		System.out.println(ans + "\n");
		
		//============================================================================================
		
		//Reduce
		int sum = 0;
		it = nums.iterator();
		while(it.hasNext())
		{
			int num = it.next();
			sum += num;
		}
		System.out.println(sum);
		
		sum = 0;
		//in reduce if initial value / seed Value is provided the returned result will be of same value's type
		//if only one parameter reduce called ..return value will be of type "Optional"
		numsStream = nums.stream();
		sum = numsStream.reduce(0, (acc, num)->acc + num);   
		System.out.println(sum + "\n");
		
		//==================================================================================================

		//distinct
		//distinct uses hashCode and equals
		List<Integer>uniqueList = new ArrayList();
		
		numsStream = nums.stream();
		uniqueList = numsStream.distinct()
		                       .collect(Collectors.toList());
		
		System.out.println(uniqueList);
		//=======================================================================================================
		
		//sorted
		numsStream = nums.stream();
		List<Integer>defaultSort = numsStream.sorted().collect(Collectors.toList());  //Integer.comapreTo() used
		System.out.println(defaultSort);
		
		numsStream = nums.stream();
		//passing lambda function to sorted param...descending sort
		List<Integer>customSort = numsStream.sorted((a, b)-> b - a).collect(Collectors.toList());
		System.out.println(customSort);
		System.out.println("\n");
		
		//==========================================================================================================
		//findFirst and findAny
		
		numsStream = nums.stream();
		Optional<Integer> op = numsStream.findFirst(); //gives first element of Stream wrapped inside optional
		if (op.isPresent())
			System.out.println("First element is = " + op.get());
		else
			System.out.println("No element found");
		
		//orElse is a method of Optional class....returns the default passed param if value is not present
		numsStream = nums.stream();
		int anyNum = numsStream.findAny().orElse(-1);
		System.out.println("Some element in list is = " + anyNum);
		
		nums = new ArrayList();
		anyNum = nums.stream().findAny().orElse(-1); //stream is empty so returns -1
		System.out.println("Some element in list is = " + anyNum);
		System.out.println("\n");
		
		//=======================================================================================================
	    //Stream on arrays
		
		int[] arr = { 12, 24, 45, 78, 90};
		IntStream arrStream = Arrays.stream(arr);  //for primitives we need to use specific streams
		
		arrStream.map((int num)->num * num)
		         .filter((int num)->num % 2 == 0)
		         .forEach((int num)->System.out.print(num + ", "));
		System.out.println("\n");
		  
		//==================================================================================================

	}

}
