package java8;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReference {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,4,5,2,1,3);
		Optional<Integer> max = list.stream().reduce(Math::max);
		max.ifPresent(p->System.out.println(p));
		
		max.ifPresent(System.out::println);
		
		List<String> strlist = Arrays.asList("My", "name", "is", "Ankit");
		List<String> sorted = strlist
				.stream()
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println(sorted);
		
		System.out.println("---------------------------");
		
		List<Integer> intlist = IntStream
				.range(1, 100)
				.boxed()
				.collect(Collectors.toCollection(ArrayList :: new));
		
		Optional<Integer> max1 = intlist.stream().reduce(Math::max);
		max1.ifPresent(System.out::println);
		
		Optional<Integer> val = Optional.of(1);
//		Optional<Integer> val = Optional.empty();
//		val.empty();
		int i = val.orElse(2);
		System.out.println(val.isPresent());
		System.out.println(i);
		val.ifPresent(System.out::println);
		
		
		
		
		
	}
}
