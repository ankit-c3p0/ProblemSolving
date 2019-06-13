package java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeePredicates {

	public static Predicate<Employee> isAdultMale() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}
	
	public static Predicate<Employee> isAdultFemale() {
		return p -> p.getGender().equalsIgnoreCase("F") && p.getAge() > 18;
	}
	
	public static Predicate<Employee> isAgeMoreThan(Integer age) {
		return p -> p.getAge() > age;
	}
	
	public static List<Employee> filter(List<Employee> employees, 
									Predicate<Employee> predicate) {
		
		return employees.stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		
		 Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
	        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
	        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
	        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
	        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
	        Employee e6 = new Employee(6,15,"M","David","Feezor");
	        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
	        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
	        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
	        Employee e10 = new Employee(10,45,"M","Naveen","Jain");
	         
	        List<Employee> employees = new ArrayList<Employee>();
	        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
	        
	        System.out.println(filter(employees, isAdultFemale()));
	        System.out.println(filter(employees, isAdultMale()));
	        System.out.println(filter(employees, isAgeMoreThan(32)));
	        
	        LocalDate local = LocalDate.now();
	        System.out.println(local.getDayOfYear());
	        System.out.println(local.getMonth());
	        System.out.println(local.getEra());
	        
	        Stream<Date> stream = Stream.generate(() -> { return new Date();});
	         stream.forEach(p -> System.out.println(p));
	     
	}
}
