

/**
 * Main class
 * 
 * @author Patrick Tudyka, p.tudyka@tu-bs.de
 */
public class Main {

	public static void main(String[] args) {
		int num0, num1, result;
		String operator;
		
		Calculator calculator = new Calculator(System.in);

		num0 = calculator.readNumber();
		num1 = calculator.readNumber();
		operator = calculator.readOperator();

		System.out.println("num0		" + num0);
		System.out.println("num1		" + num1);
		System.out.println("operator	" + operator);
		
		result = calculator.calculate(num0, num1, operator);
		System.out.println("Calculated result:	" + result);
//		System.out.println("Binary:			0b" + Integer.toBinaryString(result));
//		System.out.println("Hexadecimal:		0x" + Integer.toHexString(result).toUpperCase());

		calculator.close();
	}
}
