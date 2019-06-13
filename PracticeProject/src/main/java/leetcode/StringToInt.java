package leetcode;

public class StringToInt {
	
	public static void main(String[] args) {
		System.out.println(convertStringToInt("-123"));
	}

	public static int convertStringToInt(String numStr) {
		
		int number = 0, i=0;
		boolean isNegative = false;
		int len = numStr.length();
		if(numStr.charAt(0) == '-') {
			i=1;
			isNegative=true;
		}
		
		int asciiZero = '0';
		while(i < len) {
			number *= 10;
			number += (numStr.charAt(i++));
			number-=asciiZero;
		}
		
		if(isNegative) {
			number = -number;
		}
		return number;
	}
}
