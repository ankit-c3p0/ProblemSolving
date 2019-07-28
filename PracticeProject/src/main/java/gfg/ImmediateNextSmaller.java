package gfg;

import java.util.Scanner;

public class ImmediateNextSmaller {
	
	public static void printImmediateNextIfSmaller(int[] arr) {

		int outArr[] = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			if(i==arr.length-1) {
				outArr[i] = -1;
			} else if(arr[i]<arr[i+1]) {
				outArr[i] = -1;
			} else if (arr[i]>arr[i+1]){
				outArr[i] = arr[i+1];
			}
		}
		
		for(int i=0; i<outArr.length-1; i++) {
			System.out.print(outArr[i]+" ");
			if(i==outArr.length-2) {
				System.out.print("-1");
			}
		}
	}
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			int test = sc.nextInt();
			for(int i=0; i<test; i++) {
				
				int len = sc.nextInt();
				int[] input = new int[len];;
				for(int j=0; j<len; j++) {
					input[j] = sc.nextInt();
				}
				System.out.println();
				printImmediateNextIfSmaller(input);
			}
		}
	}

}
