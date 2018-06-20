

import java.util.Scanner;

/**
 * Class for reading and formatting input values.
 * 
 * @author Patrick Tudyka, p.tudyka@tu-bs.de
 */
public class Calculator {
	private Scanner scanner;

	private int checkNumber(String inputLine) throws NumberFormatException {

		if (inputLine.startsWith("0x")) {
			// if configuration can read binary coded numbers
			String value = inputLine.substring(2);
			return Integer.parseInt(value, 16);
		}
		return original(inputLine);
	}
}
