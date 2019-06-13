package linkedlist;

import java.util.Scanner;

public class RangeMinimumQuery {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// Declare the variable
		int len=0;
		int query=0;
		int qs=0, qe=0;

		// Read the variable from STDIN
		String arrString=null;
		len = in.nextInt();
		
		int[] arr = new int[len];
		for(int i=0; i<len; i++) {
			arr[i] = in.nextInt();
		}

		query = in.nextInt();
		qs = in.nextInt();
		qe = in.nextInt();

		int min = Integer.MIN_VALUE;
		min = arr[qs];
		for(int j=qs; j<=qe; j++) {
			if(arr[j] < min) {
				min = arr[j];
			}
		}
		
		System.out.println(min);
	}
}
