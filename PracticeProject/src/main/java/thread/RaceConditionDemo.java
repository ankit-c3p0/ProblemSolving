package thread;


import java.util.ArrayList;
import java.util.List;


public class RaceConditionDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		for(int run = 0, numThread = 100; run < 1000; run++) {
			
			System.out.print("Run %05d..." + run + 1);
			Data data = new Data();
			
			List<Thread> threadlist = new ArrayList<>(numThread);
			for(int i=0; i<numThread; i++) {
				Thread thread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						synchronized (data) { // this prevents race condition
							int value = data.getValue();
							data.setValue(value+1);
							
						}
					}
				});
				thread.start();
				threadlist.add(thread);
			}
			
			for(Thread thread: threadlist)
				thread.join();
			
			if(data.getValue() == numThread) {
				System.out.println("Passed");
			} else {
				System.out.printf("Failed with value %d instead of %d%n", data.getValue(), numThread);
		        break;
			}
		}
	}

}
