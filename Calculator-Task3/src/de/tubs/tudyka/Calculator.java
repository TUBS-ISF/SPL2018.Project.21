package de.tubs.tudyka;

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
				// #if BinaryCoded
				if (line.startsWith("0b")) {
					// if configuration can read binary coded numbers
					String value = line.substring(2);
					number = Integer.parseInt(value, 2);
					isInputValid = true;
				}
				// #endif
				// #if Hexadecimal
				if (line.startsWith("0x")) {
					// if configuration can read hexadecimal coded numbers
					String value = line.substring(2);
					number = Integer.parseInt(value, 16);
					isInputValid = true;
				}
				// #endif
				// #if Decimal
				if (!(line.startsWith("0b") || line.startsWith("0x"))) {
					// if configuration can read decimal coded numbers
					number = Integer.parseInt(line, 10);
					isInputValid = true;
				}
				// #endif
				if (!isInputValid) {
					System.out.println("Number could not be formatted.\nPlease enter a new number:");
				}
			} catch (NumberFormatException e) {
				System.out.println("Number could not be formatted.\nPlease enter a new number:");
			}
		}
		return number;
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
				System.out.println("Operator is not allowed for this configuration.\nPlease enter a new operator:");
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
		// if this configuration can use the operator "+"
		// #if Addition
		if (operator.equals("+")) {
			return true;
		}
		// #endif
		// #if Subtraction
		if (operator.equals("-")) {
			return true;
		}
		// #endif
		// #if Multiplication
		if (operator.equals("*")) {
			return true;
		}
		// #endif
		return false;
	}
	
	/**
	 * Calculates the result for the given parameters.
	 * 
	 * @param num0 First number of operation
	 * @param num1 First number of operation
	 * @param operator Operator for operation, result is 0, if there is no valid operator given
	 * 
	 * @return calculated result
	 */
	public int calculate(int num0, int num1, String operator) {
		int result = 0;
		switch (operator) {
		// #if Addition
		case "+":
			result = num0 + num1;
			break;
		// #endif
		// #if Subtraction
		case "-":
			result = num0 - num1;
			break;
		// #endif
		// #if Multiplication
		case "*":
			result = num0 * num1;
			break;
		// #endif
		default:
			break;
		}
		return result;
	}
	
	public void close() {
		scanner.close();
	}
}
