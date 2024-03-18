package dsa.algorithm;

public class Fibonacci {
	static int fib(int n)
	{
		if (n == 0) { return 0; }
		if (n == 1) { return 1; }
		
		int a = fib(n - 2);
		int b = fib(n - 1);
		int c = a + b;
		return c;
	}
	static void fibDp(int n)
	{
		int[] dp = new int[n];
		dp[0] = 0; dp[1] = 1;
		System.out.print("0 1 ");
		for (int i = 2; i < n; i++)
		{
			dp[i] = dp[i - 1] + dp[i - 2];
			System.out.print(dp[i] + " ");
		}
		System.out.println();
	}
	static void fibOptimizedDp(int n)
	{
		int a = 0, b = 1;
		System.out.print("0 1 ");
		for (int i = 0; i < n - 2; i++)
		{
			int c = a + b;
			a = b;
			b = c;
			System.out.print(c + " ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		int n = 15;
	    for (int i = 0; i < n; i++)
	    	System.out.print(fib(i) + " ");
	    
	    System.out.println();
	    fibDp(n);
	    fibOptimizedDp(n);
	}

}
