package dsa.datastructure;

public class LinkedListEx {

	public static void main(String[] args) {
		
		MyLinkedList l = new MyLinkedList();
		//================================================
		l.addAtEnd(10);
		l.addAtEnd(20);
		
		l.addAtHead(30);
		l.addAtHead(40);
		
		l.display();
		//================================================================
		l.addAtPos(50, 2);
		l.display();
		
		l.addAtPos(60, 5);
		l.display();
		
		l.addAtPos(70, 6);
		l.display();
		
		l.addAtPos(80, 8);
		l.display();
		
		l.addAtPos(90, 10);
		
		l.addAtPos(100, 1);
		l.display();
		//=================================================================
		
		l.deleteNodeByVal(40);
		l.display();
		l.deleteNodeByVal(20);
		l.display();
		l.deleteNodeByVal(100);
		l.display();
		l.deleteNodeByVal(80);
		//====================================================================
		
		l.display();
		
	}

}


class MyLinkedList
{
	
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
	
	//=============================================================================================
	void addAtEnd(int data)
	{
		Node newNode = new Node(data);
		if (head == null)
		{
			head = newNode;
			return;
		}
		
		Node curr = head;
		while(curr.next != null)
			curr = curr.next;
		
		curr.next = newNode;
		
	}
	void addAtHead(int data)
	{
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	void addAtPos(int data, int targetPos)
	{
		Node newNode = new Node(data);
		if (targetPos == 1)
		{
			addAtHead(data);
			return;
		}
			
		Node prev = null;
		Node curr = head;
		int currPos = 1;
		while(curr != null)
		{
			if (currPos == targetPos)
			{
				newNode.next = curr;
				prev.next = newNode;
				break;
			}
			prev = curr;
			curr = curr.next;
			currPos++;
		}
		
		if (currPos == targetPos)
			prev.next = newNode;
		else
			System.out.println("Wrong position inserted");
	}
	//=========================================================================================
	void deleteNodeByVal(int data)
	{
		if (head == null)
			System.out.println("Empty list");
		
		else if (head.data == data)
			head = head.next;
		
		else
		{
			Node curr = head;
			while(curr.next.data != data)
			{
				curr = curr.next;
			}
			curr.next = curr.next.next;
		}
	}
	//==============================================================================================
	void display()
	{
		Node current = head;
		
		while(current!=null)
		{
			System.out.print(current.data + "->");
			current = current.next;
			
		}
		
		System.out.println("Null");
	}
	//===================================================================================================
}


