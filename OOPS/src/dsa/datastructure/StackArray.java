package dsa.datastructure;

public class StackArray {
	public static void main(String[] args)
	{
		ArrayStack st = new ArrayStack(8);
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
		
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(60);
		st.push(70);
		st.push(80);
		
		st.push(90);
		
		st.display();
		
		
	}
}
class ArrayStack{
	int[] myStack;
	int topIdx = -1;
	
	ArrayStack(int size)
	{
		this.myStack = new int[size];
	}
	
	void push(int data)
	{
		if (topIdx == myStack.length - 1)
		{
			System.out.println("Stack overflow");
			return;
		}
		
		this.topIdx++;
		this.myStack[this.topIdx] = data;
	}
	int pop()
	{
		if (this.topIdx == -1)
		{
			System.out.println("Stack underflow");
			return -1;
		}
		int topNum = this.myStack[topIdx];
		this.topIdx--;
		return topNum;
	}
	void display()
	{
		System.out.println("Displaying from top to bottom ");
		for (int i = 0; i <= topIdx; i++)
			System.out.print(this.myStack[i] + ", ");
		System.out.println();
	}
	
}
