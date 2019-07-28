package java8;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class TestMain {
	
	public static void main(String[] args) {
	
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.HALF_UP);
		for (Number n : Arrays.asList(12, 123.12345, 0.565, 0.1, 2341234.212431324)) {
		    Double d = n.doubleValue();
		    System.out.println(df.format(d));
		}
	}
}
