

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class for reading and formatting input values.
 * 
 * @author Patrick Tudyka, p.tudyka@tu-bs.de
 */
public class Calculator {
	private Scanner scanner;

	private int checkNumber(String inputLine) throws NumberFormatException {
		
		if (!(inputLine.startsWith("0b") || inputLine.startsWith("0x"))) {
			// if configuration can read binary coded numbers
			return Integer.parseInt(inputLine, 10);
		}
		return original(inputLine);
	}
}
