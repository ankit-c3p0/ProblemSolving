package java8;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class RandomDates {

	public static void main(String[] args) throws ParseException {
		
		/*System.out.println(LocalDate.now());
		String dateString = "2019-02-06";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = df.parse(dateString);
		System.out.println();
		
		
		Timestamp t = new Timestamp(System.currentTimeMillis());*/
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MON-dd-yyyy");
//		df.s
		
		
		HashMap map = new HashMap();
		map.put("1", "two");
		map.put(2, "four");
		
//		test();
		
	}
	
	void test() {
		display(new HashSet<>());
	}
	static void display(Collection A) {
		Iterator i = A.iterator();
		while(i.hasNext()) {
//			String s = i.next();
//			System.out.println(s);
		}
	}
}
