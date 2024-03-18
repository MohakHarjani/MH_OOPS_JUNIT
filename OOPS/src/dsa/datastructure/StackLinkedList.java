package dsa.datastructure;

public class StackLinkedList {

	public static void main(String[] args) {
		ListStack st = new ListStack();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		
		st.display();
		
		st.pop();
		st.display();
		
		st.pop();
		st.display();
		
		st.pop();
		st.display();
		
		st.pop();
		st.display();
		
		st.pop();
		

	}

}

class ListStack{
	
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
	
	void push(int data)
	{
		Node newNode = new Node(data);
		if (head == null)
			head = newNode;
		else
		{
			newNode.next = head;
			head = newNode;
		}
	}
	int pop()
	{
		if (head == null)
		{
			System.out.println("Stack Empty...cannot pop");
			return -1;
		}
		else
		{
			int top = head.data;
			head = head.next;
			return top;
		}
	}
	void display()
	{
		if (head == null)
		{
			System.out.println("Stack empty cannot display");
			return;
		}
		
		System.out.println("Displaying from top to bottom");
		Node curr = head;
		while(curr != null)
		{
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
		System.out.println();
	}
	
}


