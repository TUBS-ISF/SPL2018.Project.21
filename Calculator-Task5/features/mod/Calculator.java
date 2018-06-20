
public class Calculator {

	/**
	 * Checks if the given operator is allowed for this configuration.
	 * 
	 * @param operator operator to check
	 * @return true, if operator is allowed
	 */
	private boolean checkOperator(String operator) {
		// if this configuration can use the operator "%"
		if (operator.equals("%")) {
			return true;
		}
		return original(operator);
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
		if (operator.equals("%") && (num1 != 0)) {
			return (num0 % num1);
		}
		return original(num0, num1, operator);
	}
}
