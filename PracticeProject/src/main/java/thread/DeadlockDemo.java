package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DeadlockDemo {
	
	static Logger logger = Logger.getLogger("DeadlockDemo");
	
	public static double calculateAverage(List<Integer> numlist) {
		
		int total=0;
		for(Integer num: numlist) {
			total+=num;
		}
		return total/numlist.size();
	}

	public static void main(String[] args) {
		
		List<Integer> numlist = new ArrayList<>();
		numlist.add(1);
		numlist.add(2);
		numlist.add(3);
		numlist.add(4);
		numlist.add(5);
		numlist.add(6);
		
		Thread threadA = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				double avg = calculateAverage(numlist);
				System.out.println("Average: " + avg);
				
			}
		}, "Thread-A");
		threadA.start();
		
		Thread threadB = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<numlist.size(); i++) {
					numlist.set(i, numlist.get(i)*2);
				}
				
			}
		}, "Thread-B");
		threadB.start();
		
	}
}
