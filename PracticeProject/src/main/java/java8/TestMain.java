package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestMain {
	
	public static void main(String[] args) {
		
		Emp e1 = new Emp(1, "A");
		Emp e2 = new Emp(2, "A");
		Emp e3 = new Emp(3, "A");
		Emp e4 = new Emp(4, "A");
		Emp e5 = new Emp(5, "A");
		
		List<Emp> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		
		List<Integer> list = empList.stream().map(e -> e.getId()).collect(Collectors.toList());
		list.forEach(System.out::println);
		
//		System.out.println(Optional.of(getValue()));
		
	}
	public static Integer getValue() {
		return null;
	}

}
