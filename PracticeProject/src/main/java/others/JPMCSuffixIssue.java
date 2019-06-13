package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JPMCSuffixIssue {
	
	public static String commonSuffix(String str1, String str2) {

		if (str1 == null || str2 == null)
			return null;

		int maxSuffixLength = Math.min(str1.length(), str2.length());
		int s = 0;
		while (s < maxSuffixLength && str1.charAt(str1.length() - s - 1) == str2.charAt(str2.length() - s - 1)) {
			s++;
		}
		if (validPairAt(str1, str1.length() - s - 1) || validPairAt(str2, str2.length() - s - 1)) {
			s--;
		}
		
		String lcSuffix = str1.subSequence(str1.length() - s, str1.length()).toString();
		return lcSuffix == null ? "NULL" : lcSuffix;
	}

	static boolean validPairAt(CharSequence string, int index) {
		return index >= 0 && index <= (string.length() - 2) && Character.isHighSurrogate(string.charAt(index))
				&& Character.isLowSurrogate(string.charAt(index + 1));
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		String arr[] = new String[2];
		String inputStr = null;
		while ((line = in.readLine()) != null) {
		// System.out.println(line);
		inputStr = line;
		break;
		}
		    if(inputStr != null && !inputStr.isEmpty()) {  
		        arr = inputStr.split(",");  
		    } else {  
		        System.out.println("Incorrect input string");  
		    }  

		    System.out.println(commonSuffix(arr[0].trim(), arr[1].trim()));  
		}

}
