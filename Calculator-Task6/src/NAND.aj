

public aspect NAND {

	boolean around(String operator) : execution(private boolean Calculator.checkOperator(String)) && args(operator) {
		// if this configuration can use the operator "NAND"
		if (operator.equals("NAND")) {
			return true;
		}
		return proceed(operator);
	}

	int around(int num0, int num1, String operator) : execution(public int Calculator.calculate(int, int, String)) && args(num0, num1, operator) {
		if (operator.equals("NAND")) {
			return ~(num0 & num1);
		}
		return proceed(num0, num1, operator);
	}
}
