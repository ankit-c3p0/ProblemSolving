package java8;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		
		list.forEach(p -> System.out.println(p));
	}
}
