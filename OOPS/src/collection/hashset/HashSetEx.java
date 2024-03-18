package collection.hashset;
import java.util.*;
import java.util.function.Consumer;
public class HashSetEx {
		public static void main(String[] args) {
			
			HashSet<Integer> s = new HashSet<Integer>();
			//HashSet internally uses a hashMap
			
			s.add(1);
			s.add(2);
			s.add(2);
			s.add(17);
			s.add(19);
			s.add(1);
			
			System.out.println(s.contains(17)); //true
			System.out.println(s.contains(34)); //false
			//===================================================================================
			//Iterating a hashSet
			Iterator<Integer> it = s.iterator();
			while(it.hasNext())
			{
				int val = it.next();
				System.out.print(val + ", ");
			}
			System.out.println();
			//==================================================================================
			Consumer<Integer> cc = (Integer num)->{ 
				System.out.print(num + ", ");
			};
			s.forEach(cc);
			System.out.println();
			//==================================================================================
			
			Set<String>s1 = new HashSet<String>();
			String a = "Mohak";
			String b = "Kartik";
			String c = "Punit";
			
			int ha = a.hashCode();
			int hb = b.hashCode();
			int hc = c.hashCode();
			System.out.println(a + " = " + ha + ", " + b + " = " + hb + ", " + c + " = " + hc);
			
			s1.add(a); 
			s1.add(b);
			s1.add(c);
			
			System.out.println("Mohak".hashCode());
			s1.add("Mohak");
			System.out.println(s1);
			
			
			if (s1.contains("Mohak"))
			{
				System.out.println("OK");
			}

			
			
			

		}

}
