package thread;

public class RecursiveFibonacci_DP {

	static long fiboDP(int n, long[] memo) {
		long result;
		
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		if(memo[n] != 0)
			return memo[n];
		else {
			result = fiboDP(n - 1, memo) + fiboDP(n - 2, memo);
		}
		memo[n] = result;
		return result;
	}
	
	static long fibo(int n) {
		long result;
		
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else {
			result = fibo(n - 1) + fibo(n - 2);
		}
		return result;
	}

	public static void main(String[] args) {

		int n = 5000, k=30;
		long memo[] = new long[n+1];
		long startTime = System.currentTimeMillis();
		System.out.println("Fibo");
		long result = fibo(k);
		long endTime = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("Total time:" + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		System.out.println("FiboDP");
		result = fiboDP(n, memo);
		endTime = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("Total time:" + (endTime - startTime));
		
	}
}
