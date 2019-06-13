package java8;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRomanNumber {
	 
	 public static void main(String[] args) {
	  System.out.println(getRomanEquivalentOfInteger(399));
	 }
	  
	 private static String getRomanEquivalentOfInteger(int number){
	  if(number<=0){
	   return "not defined";
	  }
	 
	  //Noting down all Unique characters where Roman numbers deviated from usual Pattern.
	  //unique patterns noted here are to support integers from 1 to 399 as program only support till 399.
	  //if we want program to support more integers then identify patterns where Roman numbers have unusual patterns after 399 and add it in map.
	  Map<Integer, String> map = new LinkedHashMap<Integer, String>();
	  map.put(100, "C");
	  map.put(90, "XC");
	  map.put(50, "L");
	  map.put(40, "XL");
	  map.put(10, "X");
	  map.put(9, "IX");
	  map.put(5, "V");
	  map.put(4, "IV");
	  map.put(1, "I");
	  
	  String romanEqui="";
	   
	  // Iterate map, check how many times given number has 100 in it, then check how many time remaining number has 90 in it and so on.
	  // or we can also say, is number divisible by 100, remaining number is divisible by 90 and so on.
	  // if number is 153, then first will see how many time number has 100 in it, which is 1 time.
	  // 100 - 1 time in 150 (remaining number is 150 - 100 = 53) OR 153/100 = 1 remaining 153%100 = 53
	  // 90  - 0 time in  53 (remaining number is  53 -  90 = 0)  OR  53/90 = 0 remaining   53 % 90 = 53 (we only need to find perfectly divisible numbers.)  
	  // 50  - 1 time in  53 (remaining number is  53 -  50 = 3)  OR  53/50 = 1 remaining   53 % 50 = 3
	  // 40  - 0 time in   3 (remaining number is   3 -  40 = 0)  OR   3/40 = 0 remaining    3 % 40 = 3
	  // 10  - 0 time in   3 (remaining number is   3 -  10 = 0)  OR   3/10 = 0 remaining    3 % 10 = 3
	  // 9   - 0 time in   3 (remaining number is   3 -   9 = 0)  OR    3/9 = 0 remaining    3 %  9 = 3
	  // 5   - 0 time in   3 (remaining number is   3 -   5 = 0)  OR    3/5 = 0 remaining    3 %  5 = 3
	  // 4   - 0 time in   3 (remaining number is   3 -   4 = 0)  OR    3/4 = 0 remaining    3 %  4 = 3
	  // 1   - 3 time in   3 (remaining number is   3 -   1 = 0)  OR    3/1 = 3 remaining    3 %  1 = 0
	  for (Map.Entry<Integer, String> entry : map.entrySet()) {
	   int key = entry.getKey();
	   if(number/key!=0){
	    for (int i = 0; i < (number/key); i++) {
	     romanEqui = romanEqui + map.get(key);
	    }
	    number = number % key;
	   }   
	  } 
	  return romanEqui;
	 }
	}
