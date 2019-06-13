package test;

import java.util.HashSet;
import java.util.Set;

public class PrintPairs {
	
	public static void main(String[] args) {
		
		int[] arr = {2, 5, 1, 6, 3, 8, 7, 9};
		int sum = 10;
		printPairsWithGivenSum(arr, sum);
	}

	public static void printPairsWithGivenSum(int[] arr, int sum) {
		
		
		Set<Integer> set = new HashSet<>(arr.length);
		for(int val: arr) {
			
			int target = sum - val;
			if(!set.contains(target)) {
				set.add(val);
			} else {
				System.out.println(val + " , " + target);
			}
		}
		
	}
}
