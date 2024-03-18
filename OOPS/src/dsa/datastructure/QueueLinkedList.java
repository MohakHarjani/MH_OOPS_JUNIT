package dsa.datastructure;

public class QueueLinkedList {

	public static void main(String[] args) {
		ListQueue st = new ListQueue();
		st.add(10);
		st.add(20);
		st.add(30);
		st.add(40);
		
		st.display();
		
		int x = st.poll();
		System.out.println(x  + " was removed");
		st.display();
		
		x = st.poll();
		System.out.println(x  + " was removed");
		st.display();
		
		x = st.poll();
		System.out.println(x  + " is popped");
		
		st.display();
		
		st.poll();
		st.display();
		
		st.poll();
		
		st.add(100);
		st.add(200);
		st.display();
		

	}

}

class ListQueue{
	
	class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	Node head = null;
	
	void add(int data)
	{
		Node newNode = new Node(data);
		if (head == null)
		{
			head = newNode;
			return;
		}
		
		Node curr = head;
		while(curr.next != null)
		{
			curr = curr.next;
		}
		curr.next = newNode;
	}
	int poll()
	{
		if (head == null)
		{
			System.out.println("Queue Empty...cannot pop");
			return -1;
		}
		else
		{
			int front = head.data;
			head = head.next;
			return front;
		}
	}
	void display()
	{
		if (head == null)
		{
			System.out.println("Queue empty cannot display");
			return;
		}
		
		System.out.println("Displaying from front to back");
		Node curr = head;
		while(curr != null)
		{
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println();
	}
	
}