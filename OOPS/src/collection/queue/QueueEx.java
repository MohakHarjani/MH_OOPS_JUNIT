package collection.queue;
import java.util.*;

public class QueueEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer>q  = new LinkedList();
		q.add(41);
		q.add(21);
		q.add(63);
		q.add(4);
		
		q.peek();
		System.out.println(q);
		
		q.poll();
		System.out.println(q);
			
	}

}
