package dsa.algorithm;

public class Factorial {
	static int fact(int n)
	{
		if (n == 1)
			return 1;
		
		return n * fact(n - 1);
	}
	static int factDp(int n)
	{
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++)
			dp[i] = i * dp[i - 1];
		
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 7;
		System.out.println(fact(n));
		System.out.println(factDp(n));

	}

}
