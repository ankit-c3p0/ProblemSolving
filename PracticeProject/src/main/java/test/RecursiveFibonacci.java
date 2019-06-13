package test;

public class RecursiveFibonacci {

	public static void main(String[] args) {
		
		int val = 5;
		for (int i=0; i<val; i++) {
			System.out.println(fibonacci(i));
		}
	}
	
	public static int fibonacci(int num) {
		if (num ==0)
			return 0;
		else if(num ==1 ||num ==2) {
			return 1;
		}
		return fibonacci(num-1) + fibonacci(num-2);
	}
}
