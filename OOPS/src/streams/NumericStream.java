package streams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.*;

public class NumericStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//of generates a stream on fly (no need to create array then call arr.stream())
		IntStream arrStream = IntStream.of(10, 20, 30, 40);
		arrStream.forEach(System.out :: println);  //instance method refernce
		System.out.println();
		
		//IntStream to Stream<Integer>
		arrStream = IntStream.of(10, 20, 30, 40);
		Stream<Integer>arrObjStream = arrStream.boxed();
		System.out.println();
		
		arrStream = arrObjStream.mapToInt((Integer i)->i.intValue());
		arrStream.forEach(System.out :: println);

		//iterate allows us to have variable step size
		arrStream = IntStream.iterate(0, (i)->i + 3).limit(10);
		arrStream.forEach(System.out :: println);
		System.out.println();
		
		//range returns a stream of int's
		//end is exclusive
		arrStream = IntStream.range(0, 10);
		arrStream.forEach(System.out :: println);
		System.out.println();
		
		//end is inclusive
		arrStream = IntStream.rangeClosed(0, 10);
		arrStream.forEach(System.out :: println);
		System.out.println();
		
		
		int sum = IntStream.rangeClosed(0, 100).sum();
		System.out.println(sum);
		System.out.println();
		
		OptionalInt intOp = IntStream.range(9, 100).min();
		System.out.println(intOp.getAsInt());
		System.out.println();
		
		
		OptionalDouble doubleOp = LongStream.range(1, 1000).average();		
		System.out.println(doubleOp.isPresent()? doubleOp.getAsDouble() : 0.00);
		System.out.println();
		
		//changing stream from one type to other
		DoubleStream dStream  = IntStream.range(13, 20).asDoubleStream();
		dStream.forEach(System.out :: println);
		System.out.println();
		
	}

}
