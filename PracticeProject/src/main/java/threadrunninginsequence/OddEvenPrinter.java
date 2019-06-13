package threadrunninginsequence;

public class OddEvenPrinter {
	
	public static void main(String[] args) {
		
		ResouceLock lock = new ResouceLock();
		
		Thread odd = new Thread(new OddPrinter(lock, 10));
		Thread even = new Thread(new EvenPrinter(lock, 10));
		
		odd.start();
		even.start();
	}

}
