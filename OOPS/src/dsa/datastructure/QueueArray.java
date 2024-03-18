package dsa.datastructure;

public class QueueArray {
	public static void main(String[] args)
	{
		ArrayQueue q = new ArrayQueue(5);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.display();
		
		q.poll();
		q.display();
		
		q.poll();
		q.display();
		
		q.add(6);
		q.display();
		
		q.add(7);
		q.display();
		
		q.add(8);
		
		q.poll();
		q.display();
		
		q.poll();
		q.display();
		
		q.poll();
		q.display();
	}

}
class ArrayQueue{
	int[] arrQueue;
	int front, rear;
	int n;
	
	ArrayQueue(int size)
	{
		this.arrQueue = new int[size];
		this.front = -1;
		this.rear = -1;
		this.n = size;
	}
	void add(int data)
	{
		if ( ((rear + 1) % n) == front)
		{
			System.out.println("Queue is full");
			return;
		}
		
		if (front == -1)
			front = 0;
		
		rear = (rear + 1) % n;
		arrQueue[rear] = data;
	}
	int poll()
	{
		if (front == -1)
		{
			System.out.println("Queue is empty");
			return -1;
		}
		
		int polledNum = arrQueue[front];
		front = (front + 1) % n;
		if (((rear + 1) % n) == front)
		{
			front = -1;
			rear = -1;
		}
		return polledNum;
	}
	void display()
	{
		if (front == -1)
		{
			System.out.println("Queue is empty...cannot display");
			return;
		}
		int i = front;
		
		while(i != rear)
		{
			
			System.out.print(arrQueue[i] + ", ");
			i = (i + 1) % n;
			
		}
		System.out.print(arrQueue[i] + ", ");
		System.out.println();
	}
}