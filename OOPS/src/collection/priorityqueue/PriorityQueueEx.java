package collection.priorityqueue;
import java.util.*;
public class PriorityQueueEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer>pq = new PriorityQueue<Integer>((Integer a, Integer b)->{
			if (a > b)
				return -1;
			else 
				return 1;
		});
		pq.add(41);
		pq.add(21);
		pq.add(63);
		pq.add(4);
		System.out.println(pq);
		
	//	pq.peek();
		System.out.println(pq.peek());
		
		pq.poll();
		System.out.println(pq);
		

	}

}
