package methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//=====================================================================
interface MyInterface{
	MyClass sum(int a, int b);   
}
class MyClass{
	//Constructors implicitly returns object of the class
    //this exactly matches the signature of sum
	MyClass(int a, int b)
	{
		System.out.println(a + b);
	}
}
//=====================================================================

class Fruit{
	String fruitName;
	Fruit(String fruitName)
	{
		this.fruitName = fruitName;
	}
	@Override
	public String toString() {
		return "Fruit [fruitName=" + fruitName + "]";
	}
}
public class ConstructorMethodRef {

	public static void main(String[] args) {
		
		MyInterface m = (a, b)-> new MyClass(a, b);
		m.sum(2, 3);  //returns a MyClass obj
		
	
		MyInterface m1 = MyClass::new;
		m.sum(2,  3);  //returns a MyClass obj
		
		List<String>fruitNames = Arrays.asList("mango", "pineapple");
		List<Fruit>ans = fruitNames.stream()
		          .map((fruitName)->new Fruit(fruitName))
		          .collect(Collectors.toList());
		System.out.println(ans);
		
		
		ans = fruitNames.stream()
        .map(Fruit :: new)
        .collect(Collectors.toList());
		
		System.out.println(ans);
	}

}
