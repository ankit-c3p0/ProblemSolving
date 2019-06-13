package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JPMCStarsNDash {
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		String inputStr = null;
		
		while ((line = in.readLine()) != null) {
			//System.out.println(line);
			inputStr = line;
			break;
		}
		
		System.out.println(matchEvenStarsDashOdd(inputStr));
	}

	public static String matchEvenStarsDashOdd(String str) {

		if (str == null && str.isEmpty())
			return "";

		str = str.replaceAll("(?<=[13579])(?=[13579])", "-");
		str = str.replaceAll("(?<=[2468])(?=[2468])", "*");
		return str;
	}

}
