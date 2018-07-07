

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class for reading and formatting input values.
 * 
 * @author Patrick Tudyka, p.tudyka@tu-bs.de
 */
public class Calculator {	
	private Scanner scanner;
	
	public Calculator(InputStream is) {
		this.scanner = new Scanner(is);
	}

	/**
	 * Read and format number from input scanner.
	 * Checks also if a specific representation is set for this configuration.
	 * 
	 * @return valid number
	 */
	public int readNumber() {
		boolean isInputValid = false;
		int number = 0;

		System.out.println("Type number:");
		while (!isInputValid) {
			String line = scanner.nextLine();
			try {
				number = checkNumber(line);
				isInputValid = true;
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
			}
		}
		return number;
	}
	
	/**
	 * Check if number from inputline is valid, and return formatted number
	 * @param inputLine String line with number to format
	 * @return formatted number, if it could be formatted
	 * @throws NumberFormatException Exception, if number could not be formatted
	 */
	private int checkNumber(String inputLine) throws NumberFormatException {
		
		throw new NumberFormatException("Number could not be formatted.\nPlease enter a new number:");
	}

	/**
	 * Read and format operator from input scanner.
	 * 
	 * @return valid operator
	 */
	public String readOperator() {
		boolean isValidInput = false;
		String operator = null;

		System.out.println("Type operator:");
		while (!isValidInput) {
			operator = scanner.nextLine();
			if (checkOperator(operator)) {
				isValidInput = true;
			} else {
				System.err.println("Operator is not allowed for this configuration.\nPlease enter a new operator:");
			}
		}
		return operator;
	}

	/**
	 * Checks if the given operator is allowed for this configuration.
	 * 
	 * @param operator operator to check
	 * @return true, if operator is allowed
	 */
	private boolean checkOperator(String operator) {
		return false;
	}
	
	/**
	 * Calculates the result for the given parameters.
	 * 
	 * @param num0 First number of operation
	 * @param num1 First number of operation
	 * @param operator Operator for operation
	 * 
	 * @return calculated result, {@link Integer#MIN_VALUE}, if there is no valid operator given
	 */
	public int calculate(int num0, int num1, String operator) {
		return Integer.MIN_VALUE;
	}
	
	public void close() {
		scanner.close();
	}
}
