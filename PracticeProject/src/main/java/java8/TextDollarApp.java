package java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextDollarApp {

	private static final int REQ_COMMAND_LINE_ARGS = 1;
	private static final int STATUS_FAILURE = 1;
	private static final String CURRENCY_TYPE = "Dollars";

	private static final String ZERO_TEXT = "Zero";
	private static final String[] DIGITS_TEXT = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
	"Nine" };
	private static final String[] TEENS_TEXT = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Nineteen" };
	private static final String[] TENS_TEXT = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };
	private static final String[] BEYONDS_TEXT = { "", "Thousand", "Million" };
	private static final int ONE_BILLION = 1000000000;
	private static final String HUNDRED_TEXT = "Hundred";
	private static final int STATUS_SUCCESS = 0;

	public static void main(String[] args) {
		String fp = "D:\\test\\input.txt";
		
		if (args.length == REQ_COMMAND_LINE_ARGS) {
			try {
				prettyTextualPrinter(fp);
			} catch (FileNotFoundException fnfe) {
				System.out.println("Caught FileNotFoundException: Unable to find the given input file");
				System.exit(STATUS_FAILURE);
			} catch (IOException ioe) {
				System.out.println("Caught IOException: Unable to read the given input file");
				System.exit(STATUS_FAILURE);
			} catch (NumberFormatException nfe) {
				System.out.println("Caught NumberFormatException: Unable to parse the amount to integer");
				System.exit(STATUS_FAILURE);
			} catch (RuntimeException re) {
				System.out.println("Caught RunTimeException: " + re.getMessage());
				System.exit(STATUS_FAILURE);
			}
		} else {
			System.out.println("Error: Invalid number of arguments");
			printUsage();
		}
		System.exit(STATUS_SUCCESS);
	}

	/**
	 * Function to read and convert amounts from the input file
	 *
	 * @param filepath:
	 *            the path of the input file containing the amounts on every line
	 * @throws FileNotFoundException:
	 *             if the given input file is not found
	 * @throws IOException:
	 *             if the given file cannot be read
	 * @throws NumberFormatException:
	 *             if any of the amount present in the file failed to converted to
	 *             long
	 * @throws RuntimeException:
	 *             if the amount is not between 0 to 1 billion
	 */
	private static void prettyTextualPrinter(String filepath) throws IOException, RuntimeException {
		BufferedReader input = new BufferedReader(new FileReader(filepath));

		boolean firstLine = true;
		while (input.ready()) {
			String amountString = input.readLine().trim().replaceAll("\\s+", "");
			if (!amountString.isEmpty()) {
				if (!firstLine) {
					System.out.print(System.lineSeparator());
				}
				long amount = Long.parseLong(amountString);
				if (amount < 0 || amount >= ONE_BILLION) {
					throw new RuntimeException("The amount should be between 0 and 1000000000");
				}
				String amountWords = printInWords(amount);
				System.out.print(amountWords);
				if (firstLine)
					firstLine = false;
			}
		}
	}

	/**
	 * Function to convert the amount in words part by part
	 *
	 * @param amount
	 *            : the amount to be converted to text
	 * @return : the amount in text
	 */
	private static String printInWords(long amount) {
		if (amount == 0)
			return ZERO_TEXT + CURRENCY_TYPE;

		StringBuilder amountInWords = new StringBuilder();
		int index = 0;
		while (amount > 0) {
			if (amount % 1000 != 0) {
				amountInWords.insert(0, amountPartToText((int) (amount % 1000)) + BEYONDS_TEXT[index]);
			}
			amount = amount / 1000;
			index++;
		}
		amountInWords.append(CURRENCY_TYPE);
		return amountInWords.toString();
	}

	/**
	 * Function to convert parts of amount in 100s part to words
	 *
	 * @param amountPart:
	 *            the part of amount
	 * @return : the amount in text
	 */
	private static String amountPartToText(int amountPart) {

		StringBuilder str = new StringBuilder();

		// 100s place conversion
		if (amountPart >= 100) {
			str.append(DIGITS_TEXT[amountPart / 100 - 1]);
			str.append(HUNDRED_TEXT);
			amountPart %= 100;
		}

		// tens place conversion
		if (amountPart >= 11 && amountPart <= 19) {
			return str.append(TEENS_TEXT[amountPart - 11]).toString();
		} else if (amountPart == 10 || amountPart >= 20) {
			str.append(TENS_TEXT[amountPart / 10 - 1]);
			amountPart %= 10;
		}

		// ones place conversion
		if (amountPart >= 1 && amountPart <= 9) {
			str.append(DIGITS_TEXT[amountPart - 1]);
		}
		return str.toString();
	}

	private static void printUsage() {
		System.out.println("TextDollar - requires " + REQ_COMMAND_LINE_ARGS + " command line arguments");
		System.out.println("filepath: the path to the input file");
	}
}
