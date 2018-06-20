

import java.io.InputStream; 

import java.util.Scanner; 

/**
 * Class for reading and formatting input values.
 * 
 * @author Patrick Tudyka, p.tudyka@tu-bs.de
 */
public   class  Calculator {
	
	private Scanner scanner  ;

	
	
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
	 private int  checkNumber__wrappee__Commandline  (String inputLine) throws NumberFormatException {
		
		throw new NumberFormatException("Number could not be formatted.\nPlease enter a new number:");
	}

	

	 private int  checkNumber__wrappee__Decimal  (String inputLine) throws NumberFormatException {
		
		if (!(inputLine.startsWith("0b") || inputLine.startsWith("0x"))) {
			// if configuration can read binary coded numbers
			return Integer.parseInt(inputLine, 10);
		}
		return checkNumber__wrappee__Commandline(inputLine);
	}

	

	 private int  checkNumber__wrappee__BinaryCoded  (String inputLine) throws NumberFormatException {
		
		if (inputLine.startsWith("0b")) {
			// if configuration can read binary coded numbers
			String value = inputLine.substring(2);
			return Integer.parseInt(value, 2);
		}
		return checkNumber__wrappee__Decimal(inputLine);
	}

	

	private int checkNumber(String inputLine) throws NumberFormatException {

		if (inputLine.startsWith("0x")) {
			// if configuration can read binary coded numbers
			String value = inputLine.substring(2);
			return Integer.parseInt(value, 16);
		}
		return checkNumber__wrappee__BinaryCoded(inputLine);
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
	 private boolean  checkOperator__wrappee__Commandline  (String operator) {
		return false;
	}

	

	/**
	 * Checks if the given operator is allowed for this configuration.
	 * 
	 * @param operator operator to check
	 * @return true, if operator is allowed
	 */
	 private boolean  checkOperator__wrappee__Addition  (String operator) {
		// if this configuration can use the operator "+"
		if (operator.equals("+")) {
			return true;
		}
		return checkOperator__wrappee__Commandline(operator);
	}

	

	/**
	 * Checks if the given operator is allowed for this configuration.
	 * 
	 * @param operator operator to check
	 * @return true, if operator is allowed
	 */
	 private boolean  checkOperator__wrappee__Subtraction  (String operator) {
		// if this configuration can use the operator "-"
		if (operator.equals("-")) {
			return true;
		}
		return checkOperator__wrappee__Addition(operator);
	}

	

	/**
	 * Checks if the given operator is allowed for this configuration.
	 * 
	 * @param operator operator to check
	 * @return true, if operator is allowed
	 */
	 private boolean  checkOperator__wrappee__Multiplication  (String operator) {
		// if this configuration can use the operator "*"
		if (operator.equals("*")) {
			return true;
		}
		return checkOperator__wrappee__Subtraction(operator);
	}

	

	/**
	 * Checks if the given operator is allowed for this configuration.
	 * 
	 * @param operator operator to check
	 * @return true, if operator is allowed
	 */
	 private boolean  checkOperator__wrappee__Division  (String operator) {
		// if this configuration can use the operator "/"
		if (operator.equals("/")) {
			return true;
		}
		return checkOperator__wrappee__Multiplication(operator);
	}

	

	/**
	 * Checks if the given operator is allowed for this configuration.
	 * 
	 * @param operator operator to check
	 * @return true, if operator is allowed
	 */
	 private boolean  checkOperator__wrappee__mod  (String operator) {
		// if this configuration can use the operator "%"
		if (operator.equals("%")) {
			return true;
		}
		return checkOperator__wrappee__Division(operator);
	}

	

	/**
	 * Checks if the given operator is allowed for this configuration.
	 * 
	 * @param operator operator to check
	 * @return true, if operator is allowed
	 */
	 private boolean  checkOperator__wrappee__AND  (String operator) {
		// if this configuration can use the operator "&"
		if (operator.equals("&")) {
			return true;
		}
		return checkOperator__wrappee__mod(operator);
	}

	

	/**
	 * Checks if the given operator is allowed for this configuration.
	 * 
	 * @param operator operator to check
	 * @return true, if operator is allowed
	 */
	private boolean checkOperator(String operator) {
		// if this configuration can use the operator "|"
		if (operator.equals("|")) {
			return true;
		}
		return checkOperator__wrappee__AND(operator);
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
	 private int  calculate__wrappee__Commandline  (int num0, int num1, String operator) {
		return Integer.MIN_VALUE;
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
	 private int  calculate__wrappee__Addition  (int num0, int num1, String operator) {
		if (operator.equals("+")) {
			return (num0 + num1);
		}
		return calculate__wrappee__Commandline(num0, num1, operator);
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
	 private int  calculate__wrappee__Subtraction  (int num0, int num1, String operator) {
		if (operator.equals("-")) {
			return (num0 - num1);
		}
		return calculate__wrappee__Addition(num0, num1, operator);
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
	 private int  calculate__wrappee__Multiplication  (int num0, int num1, String operator) {
		if (operator.equals("*")) {
			return (num0 * num1);
		}
		return calculate__wrappee__Subtraction(num0, num1, operator);
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
	 private int  calculate__wrappee__Division  (int num0, int num1, String operator) {
		if (operator.equals("/") && (num1 != 0)) {
			return (num0 / num1);
		}
		return calculate__wrappee__Multiplication(num0, num1, operator);
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
	 private int  calculate__wrappee__mod  (int num0, int num1, String operator) {
		if (operator.equals("%") && (num1 != 0)) {
			return (num0 % num1);
		}
		return calculate__wrappee__Division(num0, num1, operator);
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
	 private int  calculate__wrappee__AND  (int num0, int num1, String operator) {
		if (operator.equals("&")) {
			return (num0 & num1);
		}
		return calculate__wrappee__mod(num0, num1, operator);
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
		if (operator.equals("|")) {
			return (num0 | num1);
		}
		return calculate__wrappee__AND(num0, num1, operator);
	}

	
	
	public void close() {
		scanner.close();
	}


}
