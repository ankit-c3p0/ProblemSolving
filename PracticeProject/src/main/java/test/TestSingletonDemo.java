package test;

public class TestSingletonDemo {

	public static void main(String[] args) {
		testSingleton();
	}
	
	static void testSingleton() {
		MySingleton test1= MySingleton.getInstance();
		MySingleton test2 = MySingleton.getInstance();
		
		System.out.println(test1.hashCode());
		System.out.println(test2.hashCode());
	}
 }
