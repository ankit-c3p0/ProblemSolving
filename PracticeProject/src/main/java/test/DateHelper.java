package test;

import java.util.Date;

public class DateHelper {
	
	public static void main(String[] args) throws Exception {
		
		Date d1 = new Date();
//		Thread.sleep(10);
		Date d2 = new Date();
		
		System.out.println(d1.getTime());
		System.out.println(d2.getTime());
		
		System.out.println(d1.after(d2));
		System.out.println(d1.before(d2));
	}

}
