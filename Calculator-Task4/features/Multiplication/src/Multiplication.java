import de.tubs.tudyka.interfaces.IOperation;

public class Multiplication implements IOperation {

	@Override
	public boolean isValidOperator(String operator) {
		// if this configuration can use the operator "+"
		if (operator != null && operator.equals("*")) {
			return true;
		}
		return false;
	}

	@Override
	public int calculate(int num0, int num1, String operator) {
		if (operator == null || !operator.equals("*")) {
			throw new IllegalArgumentException("False operator");
		}
		return (num0 * num1);
	}
}
